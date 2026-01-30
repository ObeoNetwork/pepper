/*******************************************************************************
 * Copyright (c) 2026 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package fr.cea.deeplab.projectmanagement.starter.services.descriptions;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.components.collaborative.tables.api.IEditCellHandler;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.representations.Failure;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.tables.Column;
import org.eclipse.sirius.components.tables.ICell;
import org.eclipse.sirius.components.tables.Line;
import org.eclipse.sirius.components.tables.descriptions.TableDescription;
import org.springframework.stereotype.Service;

/**
 * Provide edit table cell executor for the pepper concepts.
 *
 * @author ncouvert
 */

@Service
public class PepperTableEditCellHandler implements IEditCellHandler {


    private final IObjectSearchService objectSearchService;

    public PepperTableEditCellHandler(IObjectSearchService objectSearchService) {
        this.objectSearchService = Objects.requireNonNull(objectSearchService);
    }

    @Override
    public boolean canHandle(TableDescription tableDescription) {
        return tableDescription.getId().equals("workpackagesTableId");
    }

    @Override
    public IStatus handle(IEditingContext editingContext, TableDescription tableDescription, ICell cell, Line line, Column column, Object newValue) {
        AtomicReference<IStatus> status = new AtomicReference<>(new Failure(""));
        var optionalEObject = this.objectSearchService.getObject(editingContext, line.getTargetObjectId()).filter(EObject.class::isInstance).map(EObject.class::cast);
        optionalEObject.ifPresent(eObject -> {
            var featureName = column.getTargetObjectId();
            EStructuralFeature eStructuralFeature = eObject.eClass().getEStructuralFeature(featureName);
            if (eStructuralFeature != null) {
                EClassifier eType = eStructuralFeature.getEType();
                if (eType instanceof  EDataType eDataType && eDataType.getInstanceClass().equals(LocalDate.class)) {
                    status.set(this.setDateValue(eObject, eStructuralFeature, eDataType, newValue));
                }
                else if (eStructuralFeature.isMany() && eStructuralFeature instanceof EReference && newValue instanceof Collection<?> newObjects) {
                    status.set(this.setMultiValuedReference(editingContext, eObject, eStructuralFeature, newObjects));
                } else if (!eStructuralFeature.isMany() && eStructuralFeature instanceof EReference && newValue instanceof String newStringValue) {
                    status.set(this.setMonoValuedReference(editingContext, eObject, eStructuralFeature, newStringValue));
                } else if (eType instanceof EEnum eEnum && newValue instanceof String newStringValue) {
                    status.set(this.setEEnumValue(eObject, eStructuralFeature, eEnum, newStringValue));
                } else if (eType instanceof EDataType eDataType) {
                    status.set(this.setDataTypeValue(eObject, eStructuralFeature, eDataType, newValue));
                }
            }
        });
        return status.get();
    }

    private IStatus setMultiValuedReference(IEditingContext editingContext, EObject eObject, EStructuralFeature eStructuralFeature, Collection<?> newObjects) {
        EList<EObject> values = (EList<EObject>) eObject.eGet(eStructuralFeature);
        List<EObject> newValuesToSet = new ArrayList<>();

        List<String> newValues = newObjects.stream().map(Object::toString).toList();
        for (String newStringValue : newValues) {
            var optionalNewValueToSet = this.objectSearchService.getObject(editingContext, newStringValue)
                    .filter(EObject.class::isInstance)
                    .map(EObject.class::cast);
            if (optionalNewValueToSet.isPresent()) {
                EObject newValueToSet = optionalNewValueToSet.get();

                newValuesToSet.add(newValueToSet);
                try {
                    if (!values.contains(newValueToSet)) {
                        values.add(newValueToSet);
                    }
                } catch (IllegalArgumentException | ClassCastException | ArrayStoreException exception) {
                    return new Failure("" + exception);
                }
            }
        }

        values.removeIf(value -> !newValuesToSet.contains(value));

        return new Success();
    }

    private IStatus setMonoValuedReference(IEditingContext editingContext, EObject eObject, EStructuralFeature eStructuralFeature, String newValue) {
        var optionalObject = this.objectSearchService.getObject(editingContext, newValue);

        if (optionalObject.isPresent()) {
            var object = optionalObject.get();
            eObject.eSet(eStructuralFeature, object);
            return new Success();
        }
        else {
            return new Failure("No value");
        }

    }

    private IStatus setEEnumValue(EObject eObject, EStructuralFeature eStructuralFeature, EEnum eEnum, String newValue) {
        EEnumLiteral eEnumLiteral = eEnum.getEEnumLiteral(newValue);
        eObject.eSet(eStructuralFeature, eEnumLiteral.getInstance());
        return new Success();
    }

    private IStatus setDataTypeValue(EObject eObject, EStructuralFeature eStructuralFeature, EDataType eDataType, Object newValue) {
        String newValueAsString = EcoreUtil.convertToString(eDataType, newValue);
        try {
            Object value = EcoreUtil.createFromString(eDataType, newValueAsString);
            eObject.eSet(eStructuralFeature, value);
            return new Success();
        } catch (NumberFormatException e) {
            return new Failure("The new value : " + newValueAsString + " is not valid");
        }
    }

    private IStatus setDateValue(EObject eObject, EStructuralFeature eStructuralFeature, EDataType eDataType, Object newValue) {
        String newDate = newValue.toString();
        try {
            Object value = EcoreUtil.createFromString(eDataType, newDate);
            eObject.eSet(eStructuralFeature, value);
            return new Success();
        } catch (DateTimeParseException e) {
            return new Failure("The new value : " + newDate + " is not a valid date");
        }

    }

}

