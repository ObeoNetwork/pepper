/*******************************************************************************
 * Copyright (c) 2024, 2026 CEA LIST.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 ******************************************************************************/
package pepper.peppermm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see pepper.peppermm.PepperFactory
 * @model kind="package"
 * @generated
 */
public interface PepperPackage extends EPackage {
    /**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    String eNAME = "peppermm";

    /**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_URI = "http://peppermm";

    /**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_PREFIX = "peppermm";

    /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    PepperPackage eINSTANCE = pepper.peppermm.impl.PepperPackageImpl.init();

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.NamedElementImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

				/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

				/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DESCRIPTION = 1;

				/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 2;

				/**
     * The meta object id for the '{@link pepper.peppermm.impl.OrganizationImpl <em>Organization</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.OrganizationImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getOrganization()
     * @generated
     */
    int ORGANIZATION = 1;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ORGANIZATION__NAME = NAMED_ELEMENT__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Owned Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ORGANIZATION__OWNED_PROJECTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Owned Resource Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ORGANIZATION__OWNED_RESOURCE_FOLDERS = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Organization</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ORGANIZATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link pepper.peppermm.impl.ResourceImpl <em>Resource</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.ResourceImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getResource()
     * @generated
     */
    int RESOURCE = 2;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOURCE__NAME = NAMED_ELEMENT__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Unavailability Periods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__UNAVAILABILITY_PERIODS = NAMED_ELEMENT_FEATURE_COUNT + 0;

				/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOURCE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link pepper.peppermm.impl.ResourceFolderImpl <em>Resource Folder</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.ResourceFolderImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getResourceFolder()
     * @generated
     */
    int RESOURCE_FOLDER = 3;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOURCE_FOLDER__NAME = 0;

    /**
	 * The feature id for the '<em><b>Owned Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOURCE_FOLDER__OWNED_RESOURCES = 1;

    /**
	 * The feature id for the '<em><b>Sub Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOURCE_FOLDER__SUB_FOLDERS = 2;

    /**
	 * The number of structural features of the '<em>Resource Folder</em>' class.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RESOURCE_FOLDER_FEATURE_COUNT = 3;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.TeamImpl <em>Team</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.TeamImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getTeam()
	 * @generated
	 */
    int TEAM = 4;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TEAM__NAME = RESOURCE__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__DESCRIPTION = RESOURCE__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Unavailability Periods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__UNAVAILABILITY_PERIODS = RESOURCE__UNAVAILABILITY_PERIODS;

				/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TEAM__MEMBERS = RESOURCE_FEATURE_COUNT + 0;

    /**
	 * The number of structural features of the '<em>Team</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TEAM_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.InternalStakeholderImpl <em>Internal Stakeholder</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.InternalStakeholderImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getInternalStakeholder()
	 * @generated
	 */
    int INTERNAL_STAKEHOLDER = 5;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int INTERNAL_STAKEHOLDER__NAME = RESOURCE__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_STAKEHOLDER__DESCRIPTION = RESOURCE__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Unavailability Periods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_STAKEHOLDER__UNAVAILABILITY_PERIODS = RESOURCE__UNAVAILABILITY_PERIODS;

				/**
	 * The number of structural features of the '<em>Internal Stakeholder</em>' class.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int INTERNAL_STAKEHOLDER_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.ExternalStakeholderImpl <em>External Stakeholder</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.ExternalStakeholderImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getExternalStakeholder()
	 * @generated
	 */
    int EXTERNAL_STAKEHOLDER = 6;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTERNAL_STAKEHOLDER__NAME = RESOURCE__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_STAKEHOLDER__DESCRIPTION = RESOURCE__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Unavailability Periods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_STAKEHOLDER__UNAVAILABILITY_PERIODS = RESOURCE__UNAVAILABILITY_PERIODS;

				/**
	 * The feature id for the '<em><b>Goals</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTERNAL_STAKEHOLDER__GOALS = RESOURCE_FEATURE_COUNT + 0;

    /**
	 * The number of structural features of the '<em>External Stakeholder</em>' class.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTERNAL_STAKEHOLDER_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.PersonImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getPerson()
	 * @generated
	 */
    int PERSON = 7;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PERSON__NAME = RESOURCE__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__DESCRIPTION = RESOURCE__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Unavailability Periods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__UNAVAILABILITY_PERIODS = RESOURCE__UNAVAILABILITY_PERIODS;

				/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PERSON__ALIAS = RESOURCE_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Biography</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PERSON__BIOGRAPHY = RESOURCE_FEATURE_COUNT + 1;

    /**
	 * The feature id for the '<em><b>Image Url</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PERSON__IMAGE_URL = RESOURCE_FEATURE_COUNT + 2;

    /**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PERSON_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 3;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.AssignableObjectImpl <em>Assignable Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.AssignableObjectImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getAssignableObject()
	 * @generated
	 */
	int ASSIGNABLE_OBJECT = 8;

				/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNABLE_OBJECT__NAME = NAMED_ELEMENT__NAME;

				/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNABLE_OBJECT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Assigned Persons</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNABLE_OBJECT__ASSIGNED_PERSONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

				/**
	 * The feature id for the '<em><b>Assigned Teams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNABLE_OBJECT__ASSIGNED_TEAMS = NAMED_ELEMENT_FEATURE_COUNT + 1;

				/**
	 * The number of structural features of the '<em>Assignable Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNABLE_OBJECT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

				/**
     * The meta object id for the '{@link pepper.peppermm.impl.AbstractTaskImpl <em>Abstract Task</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.AbstractTaskImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getAbstractTask()
     * @generated
     */
    int ABSTRACT_TASK = 9;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__NAME = ASSIGNABLE_OBJECT__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__DESCRIPTION = ASSIGNABLE_OBJECT__DESCRIPTION;

    /**
	 * The feature id for the '<em><b>Assigned Persons</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__ASSIGNED_PERSONS = ASSIGNABLE_OBJECT__ASSIGNED_PERSONS;

    /**
     * The feature id for the '<em><b>Assigned Teams</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_TASK__ASSIGNED_TEAMS = ASSIGNABLE_OBJECT__ASSIGNED_TEAMS;

				/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__START_TIME = ASSIGNABLE_OBJECT_FEATURE_COUNT + 0;

				/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__END_TIME = ASSIGNABLE_OBJECT_FEATURE_COUNT + 1;

				/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__PROGRESS = ASSIGNABLE_OBJECT_FEATURE_COUNT + 2;

				/**
	 * The feature id for the '<em><b>Compute Start End Dynamically</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY = ASSIGNABLE_OBJECT_FEATURE_COUNT + 3;

				/**
	 * The feature id for the '<em><b>Tags</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__TAGS = ASSIGNABLE_OBJECT_FEATURE_COUNT + 4;

    /**
	 * The feature id for the '<em><b>Sub Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__SUB_TASKS = ASSIGNABLE_OBJECT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Calculation Option</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int ABSTRACT_TASK__CALCULATION_OPTION = ASSIGNABLE_OBJECT_FEATURE_COUNT + 6;

    /**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK__DURATION = ASSIGNABLE_OBJECT_FEATURE_COUNT + 7;

    /**
	 * The feature id for the '<em><b>Effort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TASK__EFFORT = ASSIGNABLE_OBJECT_FEATURE_COUNT + 8;

				/**
	 * The number of structural features of the '<em>Abstract Task</em>' class.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ABSTRACT_TASK_FEATURE_COUNT = ASSIGNABLE_OBJECT_FEATURE_COUNT + 9;

    /**
     * The meta object id for the '{@link pepper.peppermm.impl.TagFolderImpl <em>Tag Folder</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.TagFolderImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getTagFolder()
     * @generated
     */
    int TAG_FOLDER = 10;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TAG_FOLDER__NAME = 0;

    /**
	 * The feature id for the '<em><b>Owned Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TAG_FOLDER__OWNED_TAGS = 1;

    /**
	 * The feature id for the '<em><b>Sub Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TAG_FOLDER__SUB_FOLDERS = 2;

    /**
     * The number of structural features of the '<em>Tag Folder</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TAG_FOLDER_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link pepper.peppermm.impl.TaskTagImpl <em>Task Tag</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.TaskTagImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getTaskTag()
     * @generated
     */
    int TASK_TAG = 11;

    /**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK_TAG__PREFIX = 0;

    /**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK_TAG__SUFFIX = 1;

    /**
	 * The number of structural features of the '<em>Task Tag</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK_TAG_FEATURE_COUNT = 2;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.TaskImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getTask()
	 * @generated
	 */
    int TASK = 12;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__NAME = ABSTRACT_TASK__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

    /**
	 * The feature id for the '<em><b>Assigned Persons</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__ASSIGNED_PERSONS = ABSTRACT_TASK__ASSIGNED_PERSONS;

    /**
     * The feature id for the '<em><b>Assigned Teams</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TASK__ASSIGNED_TEAMS = ABSTRACT_TASK__ASSIGNED_TEAMS;

				/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__START_TIME = ABSTRACT_TASK__START_TIME;

				/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__END_TIME = ABSTRACT_TASK__END_TIME;

				/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__PROGRESS = ABSTRACT_TASK__PROGRESS;

				/**
	 * The feature id for the '<em><b>Compute Start End Dynamically</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__COMPUTE_START_END_DYNAMICALLY = ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY;

				/**
	 * The feature id for the '<em><b>Tags</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__TAGS = ABSTRACT_TASK__TAGS;

    /**
	 * The feature id for the '<em><b>Sub Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__SUB_TASKS = ABSTRACT_TASK__SUB_TASKS;

    /**
     * The feature id for the '<em><b>Calculation Option</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TASK__CALCULATION_OPTION = ABSTRACT_TASK__CALCULATION_OPTION;

    /**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK__DURATION = ABSTRACT_TASK__DURATION;

    /**
	 * The feature id for the '<em><b>Effort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__EFFORT = ABSTRACT_TASK__EFFORT;

				/**
     * The feature id for the '<em><b>Dependencies</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int TASK__DEPENDENCIES = ABSTRACT_TASK_FEATURE_COUNT + 0;

    /**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TASK_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link pepper.peppermm.impl.ObjectiveImpl <em>Objective</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.ObjectiveImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getObjective()
     * @generated
     */
    int OBJECTIVE = 13;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__NAME = ABSTRACT_TASK__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

    /**
	 * The feature id for the '<em><b>Assigned Persons</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__ASSIGNED_PERSONS = ABSTRACT_TASK__ASSIGNED_PERSONS;

    /**
     * The feature id for the '<em><b>Assigned Teams</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int OBJECTIVE__ASSIGNED_TEAMS = ABSTRACT_TASK__ASSIGNED_TEAMS;

				/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__START_TIME = ABSTRACT_TASK__START_TIME;

				/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__END_TIME = ABSTRACT_TASK__END_TIME;

				/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__PROGRESS = ABSTRACT_TASK__PROGRESS;

				/**
	 * The feature id for the '<em><b>Compute Start End Dynamically</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__COMPUTE_START_END_DYNAMICALLY = ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY;

				/**
	 * The feature id for the '<em><b>Tags</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__TAGS = ABSTRACT_TASK__TAGS;

    /**
	 * The feature id for the '<em><b>Sub Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__SUB_TASKS = ABSTRACT_TASK__SUB_TASKS;

    /**
     * The feature id for the '<em><b>Calculation Option</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int OBJECTIVE__CALCULATION_OPTION = ABSTRACT_TASK__CALCULATION_OPTION;

    /**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__DURATION = ABSTRACT_TASK__DURATION;

    /**
	 * The feature id for the '<em><b>Effort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTIVE__EFFORT = ABSTRACT_TASK__EFFORT;

				/**
	 * The feature id for the '<em><b>Owned Key Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int OBJECTIVE__OWNED_KEY_RESULTS = ABSTRACT_TASK_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Objective</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int OBJECTIVE_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link pepper.peppermm.impl.KeyResultImpl <em>Key Result</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.KeyResultImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getKeyResult()
     * @generated
     */
    int KEY_RESULT = 14;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__NAME = ABSTRACT_TASK__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__DESCRIPTION = ABSTRACT_TASK__DESCRIPTION;

    /**
	 * The feature id for the '<em><b>Assigned Persons</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__ASSIGNED_PERSONS = ABSTRACT_TASK__ASSIGNED_PERSONS;

    /**
     * The feature id for the '<em><b>Assigned Teams</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int KEY_RESULT__ASSIGNED_TEAMS = ABSTRACT_TASK__ASSIGNED_TEAMS;

				/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__START_TIME = ABSTRACT_TASK__START_TIME;

				/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__END_TIME = ABSTRACT_TASK__END_TIME;

				/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__PROGRESS = ABSTRACT_TASK__PROGRESS;

				/**
	 * The feature id for the '<em><b>Compute Start End Dynamically</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__COMPUTE_START_END_DYNAMICALLY = ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY;

				/**
	 * The feature id for the '<em><b>Tags</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__TAGS = ABSTRACT_TASK__TAGS;

    /**
	 * The feature id for the '<em><b>Sub Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__SUB_TASKS = ABSTRACT_TASK__SUB_TASKS;

    /**
     * The feature id for the '<em><b>Calculation Option</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int KEY_RESULT__CALCULATION_OPTION = ABSTRACT_TASK__CALCULATION_OPTION;

    /**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int KEY_RESULT__DURATION = ABSTRACT_TASK__DURATION;

    /**
	 * The feature id for the '<em><b>Effort</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_RESULT__EFFORT = ABSTRACT_TASK__EFFORT;

				/**
     * The number of structural features of the '<em>Key Result</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int KEY_RESULT_FEATURE_COUNT = ABSTRACT_TASK_FEATURE_COUNT + 0;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.ProjectImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getProject()
	 * @generated
	 */
    int PROJECT = 15;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__NAME = NAMED_ELEMENT__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Owned Workpackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__OWNED_WORKPACKAGES = NAMED_ELEMENT_FEATURE_COUNT + 0;

				/**
	 * The feature id for the '<em><b>Owned Objectives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__OWNED_OBJECTIVES = NAMED_ELEMENT_FEATURE_COUNT + 1;

				/**
	 * The feature id for the '<em><b>Owned Tag Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__OWNED_TAG_FOLDERS = NAMED_ELEMENT_FEATURE_COUNT + 2;

				/**
	 * The feature id for the '<em><b>Owned Risks</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__OWNED_RISKS = NAMED_ELEMENT_FEATURE_COUNT + 3;

				/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__REFERENCE = NAMED_ELEMENT_FEATURE_COUNT + 4;

    /**
	 * The feature id for the '<em><b>Leading Unit</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__LEADING_UNIT = NAMED_ELEMENT_FEATURE_COUNT + 5;

    /**
	 * The feature id for the '<em><b>Participant Units</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__PARTICIPANT_UNITS = NAMED_ELEMENT_FEATURE_COUNT + 6;

    /**
	 * The feature id for the '<em><b>Plannified Client Copil Meetings</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS = NAMED_ELEMENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Main Program Brick</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PROJECT__MAIN_PROGRAM_BRICK = NAMED_ELEMENT_FEATURE_COUNT + 8;

    /**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__STATE = NAMED_ELEMENT_FEATURE_COUNT + 9;

    /**
	 * The feature id for the '<em><b>Clients</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__CLIENTS = NAMED_ELEMENT_FEATURE_COUNT + 10;

    /**
	 * The feature id for the '<em><b>Partners</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__PARTNERS = NAMED_ELEMENT_FEATURE_COUNT + 11;

    /**
	 * The feature id for the '<em><b>Is Transverse</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__IS_TRANSVERSE = NAMED_ELEMENT_FEATURE_COUNT + 12;

    /**
	 * The feature id for the '<em><b>Leader</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__LEADER = NAMED_ELEMENT_FEATURE_COUNT + 13;

    /**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__MEMBERS = NAMED_ELEMENT_FEATURE_COUNT + 14;

    /**
	 * The feature id for the '<em><b>Is Sensitive</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__IS_SENSITIVE = NAMED_ELEMENT_FEATURE_COUNT + 15;

    /**
	 * The feature id for the '<em><b>Contractual Start Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__CONTRACTUAL_START_DATE = NAMED_ELEMENT_FEATURE_COUNT + 16;

    /**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__DURATION = NAMED_ELEMENT_FEATURE_COUNT + 17;

    /**
	 * The feature id for the '<em><b>Contractual End Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__CONTRACTUAL_END_DATE = NAMED_ELEMENT_FEATURE_COUNT + 18;

    /**
	 * The feature id for the '<em><b>Effective Start Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__EFFECTIVE_START_DATE = NAMED_ELEMENT_FEATURE_COUNT + 19;

    /**
     * The feature id for the '<em><b>Effective End Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int PROJECT__EFFECTIVE_END_DATE = NAMED_ELEMENT_FEATURE_COUNT + 20;

    /**
	 * The feature id for the '<em><b>Contract Term Extension</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__CONTRACT_TERM_EXTENSION = NAMED_ELEMENT_FEATURE_COUNT + 21;

    /**
	 * The feature id for the '<em><b>Global Cost</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__GLOBAL_COST = NAMED_ELEMENT_FEATURE_COUNT + 22;

    /**
	 * The feature id for the '<em><b>Funding Rate</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__FUNDING_RATE = NAMED_ELEMENT_FEATURE_COUNT + 23;

    /**
	 * The feature id for the '<em><b>Funding</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__FUNDING = NAMED_ELEMENT_FEATURE_COUNT + 24;

    /**
	 * The feature id for the '<em><b>Manpower</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__MANPOWER = NAMED_ELEMENT_FEATURE_COUNT + 25;

    /**
	 * The feature id for the '<em><b>EOTP</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__EOTP = NAMED_ELEMENT_FEATURE_COUNT + 26;

    /**
	 * The feature id for the '<em><b>Statistic Order</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__STATISTIC_ORDER = NAMED_ELEMENT_FEATURE_COUNT + 27;

    /**
	 * The feature id for the '<em><b>Internal Need</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__INTERNAL_NEED = NAMED_ELEMENT_FEATURE_COUNT + 28;

    /**
	 * The feature id for the '<em><b>Client Need</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT__CLIENT_NEED = NAMED_ELEMENT_FEATURE_COUNT + 29;

    /**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROJECT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 30;

    /**
	 * The meta object id for the '{@link pepper.peppermm.DependencyRelatedObject <em>Dependency Related Object</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see pepper.peppermm.DependencyRelatedObject
	 * @see pepper.peppermm.impl.PepperPackageImpl#getDependencyRelatedObject()
	 * @generated
	 */
    int DEPENDENCY_RELATED_OBJECT = 20;

    /**
     * The meta object id for the '{@link pepper.peppermm.impl.WorkpackageImpl <em>Workpackage</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.WorkpackageImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getWorkpackage()
     * @generated
     */
    int WORKPACKAGE = 16;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__NAME = ASSIGNABLE_OBJECT__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__DESCRIPTION = ASSIGNABLE_OBJECT__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Assigned Persons</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE__ASSIGNED_PERSONS = ASSIGNABLE_OBJECT__ASSIGNED_PERSONS;

				/**
	 * The feature id for the '<em><b>Assigned Teams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKPACKAGE__ASSIGNED_TEAMS = ASSIGNABLE_OBJECT__ASSIGNED_TEAMS;

				/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__DEPENDENCIES = ASSIGNABLE_OBJECT_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__START_DATE = ASSIGNABLE_OBJECT_FEATURE_COUNT + 1;

    /**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__END_DATE = ASSIGNABLE_OBJECT_FEATURE_COUNT + 2;

    /**
	 * The feature id for the '<em><b>Leader</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__LEADER = ASSIGNABLE_OBJECT_FEATURE_COUNT + 3;

    /**
	 * The feature id for the '<em><b>Effort</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__EFFORT = ASSIGNABLE_OBJECT_FEATURE_COUNT + 4;

    /**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__OUTPUTS = ASSIGNABLE_OBJECT_FEATURE_COUNT + 5;

    /**
	 * The feature id for the '<em><b>Owned Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__OWNED_TASKS = ASSIGNABLE_OBJECT_FEATURE_COUNT + 6;

    /**
	 * The feature id for the '<em><b>Owned Objectives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__OWNED_OBJECTIVES = ASSIGNABLE_OBJECT_FEATURE_COUNT + 7;

    /**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__PROGRESS = ASSIGNABLE_OBJECT_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Calculation Option</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int WORKPACKAGE__CALCULATION_OPTION = ASSIGNABLE_OBJECT_FEATURE_COUNT + 9;

    /**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE__DURATION = ASSIGNABLE_OBJECT_FEATURE_COUNT + 10;

    /**
     * The number of structural features of the '<em>Workpackage</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int WORKPACKAGE_FEATURE_COUNT = ASSIGNABLE_OBJECT_FEATURE_COUNT + 11;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.WorkpackageArtefactImpl <em>Workpackage Artefact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.WorkpackageArtefactImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getWorkpackageArtefact()
	 * @generated
	 */
    int WORKPACKAGE_ARTEFACT = 17;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE_ARTEFACT__NAME = NAMED_ELEMENT__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE_ARTEFACT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

    /**
	 * The feature id for the '<em><b>Nature</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE_ARTEFACT__NATURE = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Planned Deadline</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Effective Dead Line</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Is Invoice Trigger</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER = NAMED_ELEMENT_FEATURE_COUNT + 3;

    /**
	 * The feature id for the '<em><b>Invoice Amount</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

    /**
	 * The feature id for the '<em><b>Responsible</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE_ARTEFACT__RESPONSIBLE = NAMED_ELEMENT_FEATURE_COUNT + 5;

    /**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE_ARTEFACT__VERSION = NAMED_ELEMENT_FEATURE_COUNT + 6;

    /**
	 * The feature id for the '<em><b>Is Obsolete</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE_ARTEFACT__IS_OBSOLETE = NAMED_ELEMENT_FEATURE_COUNT + 7;

    /**
	 * The number of structural features of the '<em>Workpackage Artefact</em>' class.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int WORKPACKAGE_ARTEFACT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 8;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.RiskImpl <em>Risk</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.RiskImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getRisk()
	 * @generated
	 */
    int RISK = 18;

    /**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RISK__KIND = 0;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RISK__DESCRIPTION = 1;

    /**
	 * The feature id for the '<em><b>Criticity</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RISK__CRITICITY = 2;

    /**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RISK__ACTION = 3;

    /**
	 * The feature id for the '<em><b>Responsible</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RISK__RESPONSIBLE = 4;

    /**
	 * The feature id for the '<em><b>Operation Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RISK__OPERATION_DATE = 5;

    /**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RISK__STATE = 6;

    /**
     * The feature id for the '<em><b>Workpackages</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    int RISK__WORKPACKAGES = 7;

    /**
	 * The number of structural features of the '<em>Risk</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int RISK_FEATURE_COUNT = 8;

    /**
     * The meta object id for the '{@link pepper.peppermm.impl.DependencyLinkImpl <em>Dependency Link</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see pepper.peppermm.impl.DependencyLinkImpl
     * @see pepper.peppermm.impl.PepperPackageImpl#getDependencyLink()
     * @generated
     */
    int DEPENDENCY_LINK = 19;

    /**
	 * The feature id for the '<em><b>Target Kind</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DEPENDENCY_LINK__TARGET_KIND = 0;

    /**
	 * The feature id for the '<em><b>Source Kind</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DEPENDENCY_LINK__SOURCE_KIND = 1;

    /**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DEPENDENCY_LINK__SOURCE = 2;

    /**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_LINK__DELAY = 3;

				/**
	 * The number of structural features of the '<em>Dependency Link</em>' class.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DEPENDENCY_LINK_FEATURE_COUNT = 4;

				/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DEPENDENCY_RELATED_OBJECT__DEPENDENCIES = 0;

				/**
	 * The number of structural features of the '<em>Dependency Related Object</em>' class.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DEPENDENCY_RELATED_OBJECT_FEATURE_COUNT = 1;

    /**
	 * The meta object id for the '{@link pepper.peppermm.impl.UnavailabilityPeriodImpl <em>Unavailability Period</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see pepper.peppermm.impl.UnavailabilityPeriodImpl
	 * @see pepper.peppermm.impl.PepperPackageImpl#getUnavailabilityPeriod()
	 * @generated
	 */
	int UNAVAILABILITY_PERIOD = 21;

				/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNAVAILABILITY_PERIOD__START_DATE = 0;

				/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNAVAILABILITY_PERIOD__END_DATE = 1;

				/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNAVAILABILITY_PERIOD__DESCRIPTION = 2;

				/**
	 * The number of structural features of the '<em>Unavailability Period</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNAVAILABILITY_PERIOD_FEATURE_COUNT = 3;

				/**
	 * The meta object id for the '{@link pepper.peppermm.WorkpackageArtefactNature <em>Workpackage Artefact Nature</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see pepper.peppermm.WorkpackageArtefactNature
	 * @see pepper.peppermm.impl.PepperPackageImpl#getWorkpackageArtefactNature()
	 * @generated
	 */
    int WORKPACKAGE_ARTEFACT_NATURE = 25;

    /**
	 * The meta object id for the '{@link pepper.peppermm.StartOrEnd <em>Start Or End</em>}' enum.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @see pepper.peppermm.StartOrEnd
	 * @see pepper.peppermm.impl.PepperPackageImpl#getStartOrEnd()
	 * @generated
	 */
    int START_OR_END = 26;

    /**
	 * The meta object id for the '{@link pepper.peppermm.TaskTimeBoundariesConstraint <em>Task Time Boundaries Constraint</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see pepper.peppermm.TaskTimeBoundariesConstraint
	 * @see pepper.peppermm.impl.PepperPackageImpl#getTaskTimeBoundariesConstraint()
	 * @generated
	 */
    int TASK_TIME_BOUNDARIES_CONSTRAINT = 27;

    /**
	 * The meta object id for the '{@link pepper.peppermm.RiskKind <em>Risk Kind</em>}' enum.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see pepper.peppermm.RiskKind
	 * @see pepper.peppermm.impl.PepperPackageImpl#getRiskKind()
	 * @generated
	 */
    int RISK_KIND = 23;

    /**
	 * The meta object id for the '{@link pepper.peppermm.RiskState <em>Risk State</em>}' enum.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see pepper.peppermm.RiskState
	 * @see pepper.peppermm.impl.PepperPackageImpl#getRiskState()
	 * @generated
	 */
    int RISK_STATE = 24;

    /**
     * The meta object id for the '{@link ProjectState <em>Project State</em>}' enum. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see ProjectState
     * @see pepper.peppermm.impl.PepperPackageImpl#getProjectState()
     * @generated
     */
    int PROJECT_STATE = 22;

    /**
	 * The meta object id for the '<em>Instant</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see java.time.Instant
	 * @see pepper.peppermm.impl.PepperPackageImpl#getInstant()
	 * @generated
	 */
    int INSTANT = 29;

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see pepper.peppermm.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

				/**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see pepper.peppermm.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

				/**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.NamedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see pepper.peppermm.NamedElement#getDescription()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Description();

				/**
	 * The meta object id for the '<em>Date</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see java.time.LocalDate
	 * @see pepper.peppermm.impl.PepperPackageImpl#getDate()
	 * @generated
	 */
    int DATE = 28;

    /**
     * Returns the meta object for class '{@link Organization <em>Organization</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Organization</em>'.
     * @see Organization
     * @generated
     */
    EClass getOrganization();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Organization#getOwnedProjects <em>Owned Projects</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Projects</em>'.
	 * @see pepper.peppermm.Organization#getOwnedProjects()
	 * @see #getOrganization()
	 * @generated
	 */
    EReference getOrganization_OwnedProjects();

    /**
     * Returns the meta object for the containment reference list
     * '{@link Organization#getOwnedResourceFolders <em>Owned Resource Folders</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '<em>Owned Resource Folders</em>'.
     * @see Organization#getOwnedResourceFolders()
     * @see #getOrganization()
     * @generated
     */
    EReference getOrganization_OwnedResourceFolders();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see pepper.peppermm.Resource
	 * @generated
	 */
    EClass getResource();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Resource#getUnavailabilityPeriods <em>Unavailability Periods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unavailability Periods</em>'.
	 * @see pepper.peppermm.Resource#getUnavailabilityPeriods()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_UnavailabilityPeriods();

				/**
     * Returns the meta object for class '{@link ResourceFolder <em>Resource Folder</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Resource Folder</em>'.
     * @see ResourceFolder
     * @generated
     */
    EClass getResourceFolder();

    /**
     * Returns the meta object for the attribute '{@link ResourceFolder#getName <em>Name</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see ResourceFolder#getName()
     * @see #getResourceFolder()
     * @generated
     */
    EAttribute getResourceFolder_Name();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.ResourceFolder#getOwnedResources <em>Owned Resources</em>}'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Resources</em>'.
	 * @see pepper.peppermm.ResourceFolder#getOwnedResources()
	 * @see #getResourceFolder()
	 * @generated
	 */
    EReference getResourceFolder_OwnedResources();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.ResourceFolder#getSubFolders <em>Sub Folders</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Folders</em>'.
	 * @see pepper.peppermm.ResourceFolder#getSubFolders()
	 * @see #getResourceFolder()
	 * @generated
	 */
    EReference getResourceFolder_SubFolders();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.Team <em>Team</em>}'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @return the meta object for class '<em>Team</em>'.
	 * @see pepper.peppermm.Team
	 * @generated
	 */
    EClass getTeam();

    /**
     * Returns the meta object for the reference list '{@link Team#getMembers <em>Members</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Members</em>'.
     * @see Team#getMembers()
     * @see #getTeam()
     * @generated
     */
    EReference getTeam_Members();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.InternalStakeholder <em>Internal Stakeholder</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Stakeholder</em>'.
	 * @see pepper.peppermm.InternalStakeholder
	 * @generated
	 */
    EClass getInternalStakeholder();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.ExternalStakeholder <em>External Stakeholder</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Stakeholder</em>'.
	 * @see pepper.peppermm.ExternalStakeholder
	 * @generated
	 */
    EClass getExternalStakeholder();

    /**
	 * Returns the meta object for the attribute list '{@link pepper.peppermm.ExternalStakeholder#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Goals</em>'.
	 * @see pepper.peppermm.ExternalStakeholder#getGoals()
	 * @see #getExternalStakeholder()
	 * @generated
	 */
    EAttribute getExternalStakeholder_Goals();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.Person <em>Person</em>}'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see pepper.peppermm.Person
	 * @generated
	 */
    EClass getPerson();

    /**
     * Returns the meta object for the attribute '{@link Person#getAlias <em>Alias</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Alias</em>'.
     * @see Person#getAlias()
     * @see #getPerson()
     * @generated
     */
    EAttribute getPerson_Alias();

    /**
     * Returns the meta object for the attribute '{@link Person#getBiography <em>Biography</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Biography</em>'.
     * @see Person#getBiography()
     * @see #getPerson()
     * @generated
     */
    EAttribute getPerson_Biography();

    /**
     * Returns the meta object for the attribute '{@link Person#getImageUrl <em>Image Url</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Image Url</em>'.
     * @see Person#getImageUrl()
     * @see #getPerson()
     * @generated
     */
    EAttribute getPerson_ImageUrl();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.AssignableObject <em>Assignable Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignable Object</em>'.
	 * @see pepper.peppermm.AssignableObject
	 * @generated
	 */
	EClass getAssignableObject();

				/**
	 * Returns the meta object for the reference list '{@link pepper.peppermm.AssignableObject#getAssignedPersons <em>Assigned Persons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assigned Persons</em>'.
	 * @see pepper.peppermm.AssignableObject#getAssignedPersons()
	 * @see #getAssignableObject()
	 * @generated
	 */
	EReference getAssignableObject_AssignedPersons();

				/**
	 * Returns the meta object for the reference list '{@link pepper.peppermm.AssignableObject#getAssignedTeams <em>Assigned Teams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assigned Teams</em>'.
	 * @see pepper.peppermm.AssignableObject#getAssignedTeams()
	 * @see #getAssignableObject()
	 * @generated
	 */
	EReference getAssignableObject_AssignedTeams();

				/**
     * Returns the meta object for class '{@link AbstractTask <em>Abstract Task</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Abstract Task</em>'.
     * @see AbstractTask
     * @generated
     */
    EClass getAbstractTask();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.AbstractTask#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see pepper.peppermm.AbstractTask#getStartTime()
	 * @see #getAbstractTask()
	 * @generated
	 */
    EAttribute getAbstractTask_StartTime();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.AbstractTask#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see pepper.peppermm.AbstractTask#getEndTime()
	 * @see #getAbstractTask()
	 * @generated
	 */
    EAttribute getAbstractTask_EndTime();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.AbstractTask#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see pepper.peppermm.AbstractTask#getProgress()
	 * @see #getAbstractTask()
	 * @generated
	 */
    EAttribute getAbstractTask_Progress();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.AbstractTask#isComputeStartEndDynamically <em>Compute Start End Dynamically</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Compute Start End Dynamically</em>'.
	 * @see pepper.peppermm.AbstractTask#isComputeStartEndDynamically()
	 * @see #getAbstractTask()
	 * @generated
	 */
    EAttribute getAbstractTask_ComputeStartEndDynamically();

    /**
     * Returns the meta object for the reference list '{@link AbstractTask#getTags <em>Tags</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Tags</em>'.
     * @see AbstractTask#getTags()
     * @see #getAbstractTask()
     * @generated
     */
    EReference getAbstractTask_Tags();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.AbstractTask#getSubTasks <em>Sub Tasks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Tasks</em>'.
	 * @see pepper.peppermm.AbstractTask#getSubTasks()
	 * @see #getAbstractTask()
	 * @generated
	 */
    EReference getAbstractTask_SubTasks();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.AbstractTask#getCalculationOption <em>Calculation Option</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calculation Option</em>'.
	 * @see pepper.peppermm.AbstractTask#getCalculationOption()
	 * @see #getAbstractTask()
	 * @generated
	 */
    EAttribute getAbstractTask_CalculationOption();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.AbstractTask#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see pepper.peppermm.AbstractTask#getDuration()
	 * @see #getAbstractTask()
	 * @generated
	 */
    EAttribute getAbstractTask_Duration();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.AbstractTask#getEffort <em>Effort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effort</em>'.
	 * @see pepper.peppermm.AbstractTask#getEffort()
	 * @see #getAbstractTask()
	 * @generated
	 */
	EAttribute getAbstractTask_Effort();

				/**
	 * Returns the meta object for class '{@link pepper.peppermm.TagFolder <em>Tag Folder</em>}'.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Folder</em>'.
	 * @see pepper.peppermm.TagFolder
	 * @generated
	 */
    EClass getTagFolder();

    /**
     * Returns the meta object for the attribute '{@link TagFolder#getName <em>Name</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see TagFolder#getName()
     * @see #getTagFolder()
     * @generated
     */
    EAttribute getTagFolder_Name();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.TagFolder#getOwnedTags <em>Owned Tags</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tags</em>'.
	 * @see pepper.peppermm.TagFolder#getOwnedTags()
	 * @see #getTagFolder()
	 * @generated
	 */
    EReference getTagFolder_OwnedTags();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.TagFolder#getSubFolders <em>Sub Folders</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Folders</em>'.
	 * @see pepper.peppermm.TagFolder#getSubFolders()
	 * @see #getTagFolder()
	 * @generated
	 */
    EReference getTagFolder_SubFolders();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.TaskTag <em>Task Tag</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Tag</em>'.
	 * @see pepper.peppermm.TaskTag
	 * @generated
	 */
    EClass getTaskTag();

    /**
     * Returns the meta object for the attribute '{@link TaskTag#getPrefix <em>Prefix</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see TaskTag#getPrefix()
     * @see #getTaskTag()
     * @generated
     */
    EAttribute getTaskTag_Prefix();

    /**
     * Returns the meta object for the attribute '{@link TaskTag#getSuffix <em>Suffix</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Suffix</em>'.
     * @see TaskTag#getSuffix()
     * @see #getTaskTag()
     * @generated
     */
    EAttribute getTaskTag_Suffix();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.Task <em>Task</em>}'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see pepper.peppermm.Task
	 * @generated
	 */
    EClass getTask();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.Objective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Objective</em>'.
	 * @see pepper.peppermm.Objective
	 * @generated
	 */
    EClass getObjective();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Objective#getOwnedKeyResults <em>Owned Key Results</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Key Results</em>'.
	 * @see pepper.peppermm.Objective#getOwnedKeyResults()
	 * @see #getObjective()
	 * @generated
	 */
    EReference getObjective_OwnedKeyResults();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.KeyResult <em>Key Result</em>}'.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Result</em>'.
	 * @see pepper.peppermm.KeyResult
	 * @generated
	 */
    EClass getKeyResult();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see pepper.peppermm.Project
	 * @generated
	 */
    EClass getProject();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Project#getOwnedWorkpackages <em>Owned Workpackages</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Workpackages</em>'.
	 * @see pepper.peppermm.Project#getOwnedWorkpackages()
	 * @see #getProject()
	 * @generated
	 */
    EReference getProject_OwnedWorkpackages();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Project#getOwnedObjectives <em>Owned Objectives</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Objectives</em>'.
	 * @see pepper.peppermm.Project#getOwnedObjectives()
	 * @see #getProject()
	 * @generated
	 */
    EReference getProject_OwnedObjectives();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Project#getOwnedTagFolders <em>Owned Tag Folders</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tag Folders</em>'.
	 * @see pepper.peppermm.Project#getOwnedTagFolders()
	 * @see #getProject()
	 * @generated
	 */
    EReference getProject_OwnedTagFolders();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Project#getOwnedRisks <em>Owned Risks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Risks</em>'.
	 * @see pepper.peppermm.Project#getOwnedRisks()
	 * @see #getProject()
	 * @generated
	 */
    EReference getProject_OwnedRisks();

    /**
     * Returns the meta object for the attribute '{@link Project#getReference <em>Reference</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Reference</em>'.
     * @see Project#getReference()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Reference();

    /**
	 * Returns the meta object for the reference '{@link pepper.peppermm.Project#getLeadingUnit <em>Leading Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Leading Unit</em>'.
	 * @see pepper.peppermm.Project#getLeadingUnit()
	 * @see #getProject()
	 * @generated
	 */
    EReference getProject_LeadingUnit();

    /**
	 * Returns the meta object for the reference list '{@link pepper.peppermm.Project#getParticipantUnits <em>Participant Units</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participant Units</em>'.
	 * @see pepper.peppermm.Project#getParticipantUnits()
	 * @see #getProject()
	 * @generated
	 */
    EReference getProject_ParticipantUnits();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getPlannifiedClientCopilMeetings <em>Plannified Client Copil Meetings</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plannified Client Copil Meetings</em>'.
	 * @see pepper.peppermm.Project#getPlannifiedClientCopilMeetings()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_PlannifiedClientCopilMeetings();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getMainProgramBrick <em>Main Program Brick</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Program Brick</em>'.
	 * @see pepper.peppermm.Project#getMainProgramBrick()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_MainProgramBrick();

    /**
     * Returns the meta object for the attribute '{@link Project#getState <em>State</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>State</em>'.
     * @see Project#getState()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_State();

    /**
	 * Returns the meta object for the reference list '{@link pepper.peppermm.Project#getClients <em>Clients</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Clients</em>'.
	 * @see pepper.peppermm.Project#getClients()
	 * @see #getProject()
	 * @generated
	 */
    EReference getProject_Clients();

    /**
	 * Returns the meta object for the reference list '{@link pepper.peppermm.Project#getPartners <em>Partners</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Partners</em>'.
	 * @see pepper.peppermm.Project#getPartners()
	 * @see #getProject()
	 * @generated
	 */
    EReference getProject_Partners();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getIsTransverse <em>Is Transverse</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Transverse</em>'.
	 * @see pepper.peppermm.Project#getIsTransverse()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_IsTransverse();

    /**
     * Returns the meta object for the reference '{@link Project#getLeader <em>Leader</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Leader</em>'.
     * @see Project#getLeader()
     * @see #getProject()
     * @generated
     */
    EReference getProject_Leader();

    /**
	 * Returns the meta object for the reference list '{@link pepper.peppermm.Project#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Members</em>'.
	 * @see pepper.peppermm.Project#getMembers()
	 * @see #getProject()
	 * @generated
	 */
    EReference getProject_Members();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getIsSensitive <em>Is Sensitive</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Sensitive</em>'.
	 * @see pepper.peppermm.Project#getIsSensitive()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_IsSensitive();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getContractualStartDate <em>Contractual Start Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contractual Start Date</em>'.
	 * @see pepper.peppermm.Project#getContractualStartDate()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_ContractualStartDate();

    /**
     * Returns the meta object for the attribute '{@link Project#getDuration <em>Duration</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Duration</em>'.
     * @see Project#getDuration()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Duration();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getContractualEndDate <em>Contractual End Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contractual End Date</em>'.
	 * @see pepper.peppermm.Project#getContractualEndDate()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_ContractualEndDate();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getEffectiveStartDate <em>Effective Start Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective Start Date</em>'.
	 * @see pepper.peppermm.Project#getEffectiveStartDate()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_EffectiveStartDate();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getEffectiveEndDate <em>Effective End Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective End Date</em>'.
	 * @see pepper.peppermm.Project#getEffectiveEndDate()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_EffectiveEndDate();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getContractTermExtension <em>Contract Term Extension</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contract Term Extension</em>'.
	 * @see pepper.peppermm.Project#getContractTermExtension()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_ContractTermExtension();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getGlobalCost <em>Global Cost</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global Cost</em>'.
	 * @see pepper.peppermm.Project#getGlobalCost()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_GlobalCost();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getFundingRate <em>Funding Rate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Funding Rate</em>'.
	 * @see pepper.peppermm.Project#getFundingRate()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_FundingRate();

    /**
     * Returns the meta object for the attribute '{@link Project#getFunding <em>Funding</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Funding</em>'.
     * @see Project#getFunding()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Funding();

    /**
     * Returns the meta object for the attribute '{@link Project#getManpower <em>Manpower</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Manpower</em>'.
     * @see Project#getManpower()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_Manpower();

    /**
     * Returns the meta object for the attribute '{@link Project#getEOTP <em>EOTP</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>EOTP</em>'.
     * @see Project#getEOTP()
     * @see #getProject()
     * @generated
     */
    EAttribute getProject_EOTP();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getStatisticOrder <em>Statistic Order</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Statistic Order</em>'.
	 * @see pepper.peppermm.Project#getStatisticOrder()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_StatisticOrder();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getInternalNeed <em>Internal Need</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Internal Need</em>'.
	 * @see pepper.peppermm.Project#getInternalNeed()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_InternalNeed();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Project#getClientNeed <em>Client Need</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Need</em>'.
	 * @see pepper.peppermm.Project#getClientNeed()
	 * @see #getProject()
	 * @generated
	 */
    EAttribute getProject_ClientNeed();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.Workpackage <em>Workpackage</em>}'.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workpackage</em>'.
	 * @see pepper.peppermm.Workpackage
	 * @generated
	 */
    EClass getWorkpackage();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Workpackage#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see pepper.peppermm.Workpackage#getStartDate()
	 * @see #getWorkpackage()
	 * @generated
	 */
    EAttribute getWorkpackage_StartDate();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Workpackage#getEndDate <em>End Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Date</em>'.
	 * @see pepper.peppermm.Workpackage#getEndDate()
	 * @see #getWorkpackage()
	 * @generated
	 */
    EAttribute getWorkpackage_EndDate();

    /**
     * Returns the meta object for the reference '{@link Workpackage#getLeader <em>Leader</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Leader</em>'.
     * @see Workpackage#getLeader()
     * @see #getWorkpackage()
     * @generated
     */
    EReference getWorkpackage_Leader();

    /**
     * Returns the meta object for the attribute '{@link Workpackage#getEffort <em>Effort</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Effort</em>'.
     * @see Workpackage#getEffort()
     * @see #getWorkpackage()
     * @generated
     */
    EAttribute getWorkpackage_Effort();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Workpackage#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see pepper.peppermm.Workpackage#getOutputs()
	 * @see #getWorkpackage()
	 * @generated
	 */
    EReference getWorkpackage_Outputs();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Workpackage#getOwnedTasks <em>Owned Tasks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tasks</em>'.
	 * @see pepper.peppermm.Workpackage#getOwnedTasks()
	 * @see #getWorkpackage()
	 * @generated
	 */
    EReference getWorkpackage_OwnedTasks();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.Workpackage#getOwnedObjectives <em>Owned Objectives</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Objectives</em>'.
	 * @see pepper.peppermm.Workpackage#getOwnedObjectives()
	 * @see #getWorkpackage()
	 * @generated
	 */
    EReference getWorkpackage_OwnedObjectives();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Workpackage#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see pepper.peppermm.Workpackage#getProgress()
	 * @see #getWorkpackage()
	 * @generated
	 */
    EAttribute getWorkpackage_Progress();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Workpackage#getCalculationOption <em>Calculation Option</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Calculation Option</em>'.
	 * @see pepper.peppermm.Workpackage#getCalculationOption()
	 * @see #getWorkpackage()
	 * @generated
	 */
    EAttribute getWorkpackage_CalculationOption();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Workpackage#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see pepper.peppermm.Workpackage#getDuration()
	 * @see #getWorkpackage()
	 * @generated
	 */
    EAttribute getWorkpackage_Duration();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.WorkpackageArtefact <em>Workpackage Artefact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workpackage Artefact</em>'.
	 * @see pepper.peppermm.WorkpackageArtefact
	 * @generated
	 */
    EClass getWorkpackageArtefact();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.WorkpackageArtefact#getNature <em>Nature</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nature</em>'.
	 * @see pepper.peppermm.WorkpackageArtefact#getNature()
	 * @see #getWorkpackageArtefact()
	 * @generated
	 */
    EAttribute getWorkpackageArtefact_Nature();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.WorkpackageArtefact#getPlannedDeadline <em>Planned Deadline</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Planned Deadline</em>'.
	 * @see pepper.peppermm.WorkpackageArtefact#getPlannedDeadline()
	 * @see #getWorkpackageArtefact()
	 * @generated
	 */
    EAttribute getWorkpackageArtefact_PlannedDeadline();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.WorkpackageArtefact#getEffectiveDeadLine <em>Effective Dead Line</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Effective Dead Line</em>'.
	 * @see pepper.peppermm.WorkpackageArtefact#getEffectiveDeadLine()
	 * @see #getWorkpackageArtefact()
	 * @generated
	 */
    EAttribute getWorkpackageArtefact_EffectiveDeadLine();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.WorkpackageArtefact#getIsInvoiceTrigger <em>Is Invoice Trigger</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Invoice Trigger</em>'.
	 * @see pepper.peppermm.WorkpackageArtefact#getIsInvoiceTrigger()
	 * @see #getWorkpackageArtefact()
	 * @generated
	 */
    EAttribute getWorkpackageArtefact_IsInvoiceTrigger();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.WorkpackageArtefact#getInvoiceAmount <em>Invoice Amount</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invoice Amount</em>'.
	 * @see pepper.peppermm.WorkpackageArtefact#getInvoiceAmount()
	 * @see #getWorkpackageArtefact()
	 * @generated
	 */
    EAttribute getWorkpackageArtefact_InvoiceAmount();

    /**
	 * Returns the meta object for the reference '{@link pepper.peppermm.WorkpackageArtefact#getResponsible <em>Responsible</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsible</em>'.
	 * @see pepper.peppermm.WorkpackageArtefact#getResponsible()
	 * @see #getWorkpackageArtefact()
	 * @generated
	 */
    EReference getWorkpackageArtefact_Responsible();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.WorkpackageArtefact#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see pepper.peppermm.WorkpackageArtefact#getVersion()
	 * @see #getWorkpackageArtefact()
	 * @generated
	 */
    EAttribute getWorkpackageArtefact_Version();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.WorkpackageArtefact#getIsObsolete <em>Is Obsolete</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Obsolete</em>'.
	 * @see pepper.peppermm.WorkpackageArtefact#getIsObsolete()
	 * @see #getWorkpackageArtefact()
	 * @generated
	 */
    EAttribute getWorkpackageArtefact_IsObsolete();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.Risk <em>Risk</em>}'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @return the meta object for class '<em>Risk</em>'.
	 * @see pepper.peppermm.Risk
	 * @generated
	 */
    EClass getRisk();

    /**
     * Returns the meta object for the attribute '{@link Risk#getKind <em>Kind</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see Risk#getKind()
     * @see #getRisk()
     * @generated
     */
    EAttribute getRisk_Kind();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Risk#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see pepper.peppermm.Risk#getDescription()
	 * @see #getRisk()
	 * @generated
	 */
    EAttribute getRisk_Description();

    /**
     * Returns the meta object for the attribute '{@link Risk#getCriticity <em>Criticity</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Criticity</em>'.
     * @see Risk#getCriticity()
     * @see #getRisk()
     * @generated
     */
    EAttribute getRisk_Criticity();

    /**
     * Returns the meta object for the attribute '{@link Risk#getAction <em>Action</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Action</em>'.
     * @see Risk#getAction()
     * @see #getRisk()
     * @generated
     */
    EAttribute getRisk_Action();

    /**
	 * Returns the meta object for the reference '{@link pepper.peppermm.Risk#getResponsible <em>Responsible</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Responsible</em>'.
	 * @see pepper.peppermm.Risk#getResponsible()
	 * @see #getRisk()
	 * @generated
	 */
    EReference getRisk_Responsible();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.Risk#getOperationDate <em>Operation Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Date</em>'.
	 * @see pepper.peppermm.Risk#getOperationDate()
	 * @see #getRisk()
	 * @generated
	 */
    EAttribute getRisk_OperationDate();

    /**
     * Returns the meta object for the attribute '{@link Risk#getState <em>State</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>State</em>'.
     * @see Risk#getState()
     * @see #getRisk()
     * @generated
     */
    EAttribute getRisk_State();

    /**
	 * Returns the meta object for the reference list '{@link pepper.peppermm.Risk#getWorkpackages <em>Workpackages</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Workpackages</em>'.
	 * @see pepper.peppermm.Risk#getWorkpackages()
	 * @see #getRisk()
	 * @generated
	 */
    EReference getRisk_Workpackages();

    /**
     * Returns the meta object for class '{@link DependencyLink <em>Dependency Link</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Dependency Link</em>'.
     * @see DependencyLink
     * @generated
     */
    EClass getDependencyLink();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.DependencyLink#getTargetKind <em>Target Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Kind</em>'.
	 * @see pepper.peppermm.DependencyLink#getTargetKind()
	 * @see #getDependencyLink()
	 * @generated
	 */
    EAttribute getDependencyLink_TargetKind();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.DependencyLink#getSourceKind <em>Source Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Kind</em>'.
	 * @see pepper.peppermm.DependencyLink#getSourceKind()
	 * @see #getDependencyLink()
	 * @generated
	 */
    EAttribute getDependencyLink_SourceKind();

    /**
	 * Returns the meta object for the reference '{@link pepper.peppermm.DependencyLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see pepper.peppermm.DependencyLink#getSource()
	 * @see #getDependencyLink()
	 * @generated
	 */
    EReference getDependencyLink_Source();

    /**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.DependencyLink#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see pepper.peppermm.DependencyLink#getDelay()
	 * @see #getDependencyLink()
	 * @generated
	 */
	EAttribute getDependencyLink_Delay();

				/**
	 * Returns the meta object for class '{@link pepper.peppermm.DependencyRelatedObject <em>Dependency Related Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Related Object</em>'.
	 * @see pepper.peppermm.DependencyRelatedObject
	 * @generated
	 */
    EClass getDependencyRelatedObject();

    /**
	 * Returns the meta object for the containment reference list '{@link pepper.peppermm.DependencyRelatedObject#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see pepper.peppermm.DependencyRelatedObject#getDependencies()
	 * @see #getDependencyRelatedObject()
	 * @generated
	 */
    EReference getDependencyRelatedObject_Dependencies();

    /**
	 * Returns the meta object for class '{@link pepper.peppermm.UnavailabilityPeriod <em>Unavailability Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unavailability Period</em>'.
	 * @see pepper.peppermm.UnavailabilityPeriod
	 * @generated
	 */
	EClass getUnavailabilityPeriod();

				/**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.UnavailabilityPeriod#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see pepper.peppermm.UnavailabilityPeriod#getStartDate()
	 * @see #getUnavailabilityPeriod()
	 * @generated
	 */
	EAttribute getUnavailabilityPeriod_StartDate();

				/**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.UnavailabilityPeriod#getEndDate <em>End Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Date</em>'.
	 * @see pepper.peppermm.UnavailabilityPeriod#getEndDate()
	 * @see #getUnavailabilityPeriod()
	 * @generated
	 */
	EAttribute getUnavailabilityPeriod_EndDate();

				/**
	 * Returns the meta object for the attribute '{@link pepper.peppermm.UnavailabilityPeriod#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see pepper.peppermm.UnavailabilityPeriod#getDescription()
	 * @see #getUnavailabilityPeriod()
	 * @generated
	 */
	EAttribute getUnavailabilityPeriod_Description();

				/**
	 * Returns the meta object for enum '{@link pepper.peppermm.WorkpackageArtefactNature <em>Workpackage Artefact Nature</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Workpackage Artefact Nature</em>'.
	 * @see pepper.peppermm.WorkpackageArtefactNature
	 * @generated
	 */
    EEnum getWorkpackageArtefactNature();

    /**
	 * Returns the meta object for enum '{@link pepper.peppermm.StartOrEnd <em>Start Or End</em>}'.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Start Or End</em>'.
	 * @see pepper.peppermm.StartOrEnd
	 * @generated
	 */
    EEnum getStartOrEnd();

    /**
	 * Returns the meta object for enum '{@link pepper.peppermm.TaskTimeBoundariesConstraint <em>Task Time Boundaries Constraint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Task Time Boundaries Constraint</em>'.
	 * @see pepper.peppermm.TaskTimeBoundariesConstraint
	 * @generated
	 */
    EEnum getTaskTimeBoundariesConstraint();

    /**
	 * Returns the meta object for enum '{@link pepper.peppermm.RiskKind <em>Risk Kind</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Risk Kind</em>'.
	 * @see pepper.peppermm.RiskKind
	 * @generated
	 */
    EEnum getRiskKind();

    /**
	 * Returns the meta object for enum '{@link pepper.peppermm.RiskState <em>Risk State</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Risk State</em>'.
	 * @see pepper.peppermm.RiskState
	 * @generated
	 */
    EEnum getRiskState();

    /**
     * Returns the meta object for enum '{@link ProjectState <em>Project State</em>}'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Project State</em>'.
     * @see ProjectState
     * @generated
     */
    EEnum getProjectState();

    /**
	 * Returns the meta object for data type '{@link java.time.Instant <em>Instant</em>}'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @return the meta object for data type '<em>Instant</em>'.
	 * @see java.time.Instant
	 * @model instanceClass="java.time.Instant"
	 * @generated
	 */
    EDataType getInstant();

    /**
	 * Returns the meta object for data type '{@link java.time.LocalDate <em>Date</em>}'.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @return the meta object for data type '<em>Date</em>'.
	 * @see java.time.LocalDate
	 * @model instanceClass="java.time.LocalDate"
	 * @generated
	 */
    EDataType getDate();

    /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
    PepperFactory getPepperFactory();

    /**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
	 * @generated
	 */
    interface Literals {
        /**
		 * The meta object literal for the '{@link pepper.peppermm.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.NamedElementImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

					/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

					/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__DESCRIPTION = eINSTANCE.getNamedElement_Description();

								/**
		 * The meta object literal for the '{@link pepper.peppermm.impl.OrganizationImpl <em>Organization</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.OrganizationImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getOrganization()
		 * @generated
		 */
        EClass ORGANIZATION = eINSTANCE.getOrganization();

        /**
         * The meta object literal for the '<em><b>Owned Projects</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ORGANIZATION__OWNED_PROJECTS = eINSTANCE.getOrganization_OwnedProjects();

        /**
		 * The meta object literal for the '<em><b>Owned Resource Folders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
        EReference ORGANIZATION__OWNED_RESOURCE_FOLDERS = eINSTANCE.getOrganization_OwnedResourceFolders();

        /**
         * The meta object literal for the '{@link pepper.peppermm.impl.ResourceImpl <em>Resource</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.ResourceImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getResource()
         * @generated
         */
        EClass RESOURCE = eINSTANCE.getResource();

        /**
		 * The meta object literal for the '<em><b>Unavailability Periods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__UNAVAILABILITY_PERIODS = eINSTANCE.getResource_UnavailabilityPeriods();

								/**
		 * The meta object literal for the '{@link pepper.peppermm.impl.ResourceFolderImpl <em>Resource Folder</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.ResourceFolderImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getResourceFolder()
		 * @generated
		 */
        EClass RESOURCE_FOLDER = eINSTANCE.getResourceFolder();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute RESOURCE_FOLDER__NAME = eINSTANCE.getResourceFolder_Name();

        /**
         * The meta object literal for the '<em><b>Owned Resources</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference RESOURCE_FOLDER__OWNED_RESOURCES = eINSTANCE.getResourceFolder_OwnedResources();

        /**
         * The meta object literal for the '<em><b>Sub Folders</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference RESOURCE_FOLDER__SUB_FOLDERS = eINSTANCE.getResourceFolder_SubFolders();

        /**
         * The meta object literal for the '{@link pepper.peppermm.impl.TeamImpl <em>Team</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.TeamImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getTeam()
         * @generated
         */
        EClass TEAM = eINSTANCE.getTeam();

        /**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference TEAM__MEMBERS = eINSTANCE.getTeam_Members();

        /**
		 * The meta object literal for the '{@link pepper.peppermm.impl.InternalStakeholderImpl <em>Internal Stakeholder</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.InternalStakeholderImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getInternalStakeholder()
		 * @generated
		 */
        EClass INTERNAL_STAKEHOLDER = eINSTANCE.getInternalStakeholder();

        /**
		 * The meta object literal for the '{@link pepper.peppermm.impl.ExternalStakeholderImpl <em>External Stakeholder</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.ExternalStakeholderImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getExternalStakeholder()
		 * @generated
		 */
        EClass EXTERNAL_STAKEHOLDER = eINSTANCE.getExternalStakeholder();

        /**
		 * The meta object literal for the '<em><b>Goals</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute EXTERNAL_STAKEHOLDER__GOALS = eINSTANCE.getExternalStakeholder_Goals();

        /**
         * The meta object literal for the '{@link pepper.peppermm.impl.PersonImpl <em>Person</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.PersonImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getPerson()
         * @generated
         */
        EClass PERSON = eINSTANCE.getPerson();

        /**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PERSON__ALIAS = eINSTANCE.getPerson_Alias();

        /**
		 * The meta object literal for the '<em><b>Biography</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PERSON__BIOGRAPHY = eINSTANCE.getPerson_Biography();

        /**
		 * The meta object literal for the '<em><b>Image Url</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PERSON__IMAGE_URL = eINSTANCE.getPerson_ImageUrl();

        /**
		 * The meta object literal for the '{@link pepper.peppermm.impl.AssignableObjectImpl <em>Assignable Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.AssignableObjectImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getAssignableObject()
		 * @generated
		 */
		EClass ASSIGNABLE_OBJECT = eINSTANCE.getAssignableObject();

								/**
		 * The meta object literal for the '<em><b>Assigned Persons</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNABLE_OBJECT__ASSIGNED_PERSONS = eINSTANCE.getAssignableObject_AssignedPersons();

								/**
		 * The meta object literal for the '<em><b>Assigned Teams</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNABLE_OBJECT__ASSIGNED_TEAMS = eINSTANCE.getAssignableObject_AssignedTeams();

								/**
		 * The meta object literal for the '{@link pepper.peppermm.impl.AbstractTaskImpl <em>Abstract Task</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.AbstractTaskImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getAbstractTask()
		 * @generated
		 */
        EClass ABSTRACT_TASK = eINSTANCE.getAbstractTask();

        /**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute ABSTRACT_TASK__START_TIME = eINSTANCE.getAbstractTask_StartTime();

        /**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute ABSTRACT_TASK__END_TIME = eINSTANCE.getAbstractTask_EndTime();

        /**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute ABSTRACT_TASK__PROGRESS = eINSTANCE.getAbstractTask_Progress();

        /**
         * The meta object literal for the '<em><b>Compute Start End Dynamically</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY = eINSTANCE.getAbstractTask_ComputeStartEndDynamically();

        /**
		 * The meta object literal for the '<em><b>Tags</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EReference ABSTRACT_TASK__TAGS = eINSTANCE.getAbstractTask_Tags();

        /**
         * The meta object literal for the '<em><b>Sub Tasks</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ABSTRACT_TASK__SUB_TASKS = eINSTANCE.getAbstractTask_SubTasks();

        /**
		 * The meta object literal for the '<em><b>Calculation Option</b></em>' attribute feature.
		 * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute ABSTRACT_TASK__CALCULATION_OPTION = eINSTANCE.getAbstractTask_CalculationOption();

        /**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute ABSTRACT_TASK__DURATION = eINSTANCE.getAbstractTask_Duration();

        /**
		 * The meta object literal for the '<em><b>Effort</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_TASK__EFFORT = eINSTANCE.getAbstractTask_Effort();

								/**
         * The meta object literal for the '{@link pepper.peppermm.impl.TagFolderImpl <em>Tag Folder</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.TagFolderImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getTagFolder()
         * @generated
         */
        EClass TAG_FOLDER = eINSTANCE.getTagFolder();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute TAG_FOLDER__NAME = eINSTANCE.getTagFolder_Name();

        /**
         * The meta object literal for the '<em><b>Owned Tags</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TAG_FOLDER__OWNED_TAGS = eINSTANCE.getTagFolder_OwnedTags();

        /**
         * The meta object literal for the '<em><b>Sub Folders</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference TAG_FOLDER__SUB_FOLDERS = eINSTANCE.getTagFolder_SubFolders();

        /**
         * The meta object literal for the '{@link pepper.peppermm.impl.TaskTagImpl <em>Task Tag</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.TaskTagImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getTaskTag()
         * @generated
         */
        EClass TASK_TAG = eINSTANCE.getTaskTag();

        /**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute TASK_TAG__PREFIX = eINSTANCE.getTaskTag_Prefix();

        /**
		 * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute TASK_TAG__SUFFIX = eINSTANCE.getTaskTag_Suffix();

        /**
         * The meta object literal for the '{@link pepper.peppermm.impl.TaskImpl <em>Task</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.TaskImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getTask()
         * @generated
         */
        EClass TASK = eINSTANCE.getTask();

        /**
         * The meta object literal for the '{@link pepper.peppermm.impl.ObjectiveImpl <em>Objective</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.ObjectiveImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getObjective()
         * @generated
         */
        EClass OBJECTIVE = eINSTANCE.getObjective();

        /**
         * The meta object literal for the '<em><b>Owned Key Results</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference OBJECTIVE__OWNED_KEY_RESULTS = eINSTANCE.getObjective_OwnedKeyResults();

        /**
         * The meta object literal for the '{@link pepper.peppermm.impl.KeyResultImpl <em>Key Result</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.KeyResultImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getKeyResult()
         * @generated
         */
        EClass KEY_RESULT = eINSTANCE.getKeyResult();

        /**
         * The meta object literal for the '{@link pepper.peppermm.impl.ProjectImpl <em>Project</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.ProjectImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getProject()
         * @generated
         */
        EClass PROJECT = eINSTANCE.getProject();

        /**
         * The meta object literal for the '<em><b>Owned Workpackages</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROJECT__OWNED_WORKPACKAGES = eINSTANCE.getProject_OwnedWorkpackages();

        /**
         * The meta object literal for the '<em><b>Owned Objectives</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROJECT__OWNED_OBJECTIVES = eINSTANCE.getProject_OwnedObjectives();

        /**
         * The meta object literal for the '<em><b>Owned Tag Folders</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROJECT__OWNED_TAG_FOLDERS = eINSTANCE.getProject_OwnedTagFolders();

        /**
         * The meta object literal for the '<em><b>Owned Risks</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROJECT__OWNED_RISKS = eINSTANCE.getProject_OwnedRisks();

        /**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__REFERENCE = eINSTANCE.getProject_Reference();

        /**
		 * The meta object literal for the '<em><b>Leading Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PROJECT__LEADING_UNIT = eINSTANCE.getProject_LeadingUnit();

        /**
         * The meta object literal for the '<em><b>Participant Units</b></em>' reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROJECT__PARTICIPANT_UNITS = eINSTANCE.getProject_ParticipantUnits();

        /**
         * The meta object literal for the '<em><b>Plannified Client Copil Meetings</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS = eINSTANCE.getProject_PlannifiedClientCopilMeetings();

        /**
		 * The meta object literal for the '<em><b>Main Program Brick</b></em>' attribute feature.
		 * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__MAIN_PROGRAM_BRICK = eINSTANCE.getProject_MainProgramBrick();

        /**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__STATE = eINSTANCE.getProject_State();

        /**
		 * The meta object literal for the '<em><b>Clients</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PROJECT__CLIENTS = eINSTANCE.getProject_Clients();

        /**
		 * The meta object literal for the '<em><b>Partners</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PROJECT__PARTNERS = eINSTANCE.getProject_Partners();

        /**
		 * The meta object literal for the '<em><b>Is Transverse</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__IS_TRANSVERSE = eINSTANCE.getProject_IsTransverse();

        /**
		 * The meta object literal for the '<em><b>Leader</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EReference PROJECT__LEADER = eINSTANCE.getProject_Leader();

        /**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PROJECT__MEMBERS = eINSTANCE.getProject_Members();

        /**
		 * The meta object literal for the '<em><b>Is Sensitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__IS_SENSITIVE = eINSTANCE.getProject_IsSensitive();

        /**
         * The meta object literal for the '<em><b>Contractual Start Date</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PROJECT__CONTRACTUAL_START_DATE = eINSTANCE.getProject_ContractualStartDate();

        /**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__DURATION = eINSTANCE.getProject_Duration();

        /**
		 * The meta object literal for the '<em><b>Contractual End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__CONTRACTUAL_END_DATE = eINSTANCE.getProject_ContractualEndDate();

        /**
		 * The meta object literal for the '<em><b>Effective Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__EFFECTIVE_START_DATE = eINSTANCE.getProject_EffectiveStartDate();

        /**
		 * The meta object literal for the '<em><b>Effective End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__EFFECTIVE_END_DATE = eINSTANCE.getProject_EffectiveEndDate();

        /**
         * The meta object literal for the '<em><b>Contract Term Extension</b></em>' attribute feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PROJECT__CONTRACT_TERM_EXTENSION = eINSTANCE.getProject_ContractTermExtension();

        /**
		 * The meta object literal for the '<em><b>Global Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__GLOBAL_COST = eINSTANCE.getProject_GlobalCost();

        /**
		 * The meta object literal for the '<em><b>Funding Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__FUNDING_RATE = eINSTANCE.getProject_FundingRate();

        /**
		 * The meta object literal for the '<em><b>Funding</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__FUNDING = eINSTANCE.getProject_Funding();

        /**
		 * The meta object literal for the '<em><b>Manpower</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__MANPOWER = eINSTANCE.getProject_Manpower();

        /**
		 * The meta object literal for the '<em><b>EOTP</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__EOTP = eINSTANCE.getProject_EOTP();

        /**
		 * The meta object literal for the '<em><b>Statistic Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__STATISTIC_ORDER = eINSTANCE.getProject_StatisticOrder();

        /**
		 * The meta object literal for the '<em><b>Internal Need</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__INTERNAL_NEED = eINSTANCE.getProject_InternalNeed();

        /**
		 * The meta object literal for the '<em><b>Client Need</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute PROJECT__CLIENT_NEED = eINSTANCE.getProject_ClientNeed();

        /**
		 * The meta object literal for the '{@link pepper.peppermm.impl.WorkpackageImpl <em>Workpackage</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.WorkpackageImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getWorkpackage()
		 * @generated
		 */
        EClass WORKPACKAGE = eINSTANCE.getWorkpackage();

        /**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE__START_DATE = eINSTANCE.getWorkpackage_StartDate();

        /**
		 * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE__END_DATE = eINSTANCE.getWorkpackage_EndDate();

        /**
		 * The meta object literal for the '<em><b>Leader</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EReference WORKPACKAGE__LEADER = eINSTANCE.getWorkpackage_Leader();

        /**
		 * The meta object literal for the '<em><b>Effort</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE__EFFORT = eINSTANCE.getWorkpackage_Effort();

        /**
         * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference WORKPACKAGE__OUTPUTS = eINSTANCE.getWorkpackage_Outputs();

        /**
         * The meta object literal for the '<em><b>Owned Tasks</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference WORKPACKAGE__OWNED_TASKS = eINSTANCE.getWorkpackage_OwnedTasks();

        /**
         * The meta object literal for the '<em><b>Owned Objectives</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference WORKPACKAGE__OWNED_OBJECTIVES = eINSTANCE.getWorkpackage_OwnedObjectives();

        /**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE__PROGRESS = eINSTANCE.getWorkpackage_Progress();

        /**
		 * The meta object literal for the '<em><b>Calculation Option</b></em>' attribute feature.
		 * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE__CALCULATION_OPTION = eINSTANCE.getWorkpackage_CalculationOption();

        /**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE__DURATION = eINSTANCE.getWorkpackage_Duration();

        /**
		 * The meta object literal for the '{@link pepper.peppermm.impl.WorkpackageArtefactImpl <em>Workpackage Artefact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.WorkpackageArtefactImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getWorkpackageArtefact()
		 * @generated
		 */
        EClass WORKPACKAGE_ARTEFACT = eINSTANCE.getWorkpackageArtefact();

        /**
		 * The meta object literal for the '<em><b>Nature</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE_ARTEFACT__NATURE = eINSTANCE.getWorkpackageArtefact_Nature();

        /**
		 * The meta object literal for the '<em><b>Planned Deadline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE = eINSTANCE.getWorkpackageArtefact_PlannedDeadline();

        /**
		 * The meta object literal for the '<em><b>Effective Dead Line</b></em>' attribute feature.
		 * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE = eINSTANCE.getWorkpackageArtefact_EffectiveDeadLine();

        /**
		 * The meta object literal for the '<em><b>Is Invoice Trigger</b></em>' attribute feature.
		 * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER = eINSTANCE.getWorkpackageArtefact_IsInvoiceTrigger();

        /**
		 * The meta object literal for the '<em><b>Invoice Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT = eINSTANCE.getWorkpackageArtefact_InvoiceAmount();

        /**
		 * The meta object literal for the '<em><b>Responsible</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EReference WORKPACKAGE_ARTEFACT__RESPONSIBLE = eINSTANCE.getWorkpackageArtefact_Responsible();

        /**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE_ARTEFACT__VERSION = eINSTANCE.getWorkpackageArtefact_Version();

        /**
		 * The meta object literal for the '<em><b>Is Obsolete</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute WORKPACKAGE_ARTEFACT__IS_OBSOLETE = eINSTANCE.getWorkpackageArtefact_IsObsolete();

        /**
         * The meta object literal for the '{@link pepper.peppermm.impl.RiskImpl <em>Risk</em>}' class. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see pepper.peppermm.impl.RiskImpl
         * @see pepper.peppermm.impl.PepperPackageImpl#getRisk()
         * @generated
         */
        EClass RISK = eINSTANCE.getRisk();

        /**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute RISK__KIND = eINSTANCE.getRisk_Kind();

        /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute RISK__DESCRIPTION = eINSTANCE.getRisk_Description();

        /**
		 * The meta object literal for the '<em><b>Criticity</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute RISK__CRITICITY = eINSTANCE.getRisk_Criticity();

        /**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute RISK__ACTION = eINSTANCE.getRisk_Action();

        /**
		 * The meta object literal for the '<em><b>Responsible</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EReference RISK__RESPONSIBLE = eINSTANCE.getRisk_Responsible();

        /**
		 * The meta object literal for the '<em><b>Operation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute RISK__OPERATION_DATE = eINSTANCE.getRisk_OperationDate();

        /**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute RISK__STATE = eINSTANCE.getRisk_State();

        /**
		 * The meta object literal for the '<em><b>Workpackages</b></em>' reference list feature.
		 * <!-- begin-user-doc
         * --> <!-- end-user-doc -->
		 * @generated
		 */
        EReference RISK__WORKPACKAGES = eINSTANCE.getRisk_Workpackages();

        /**
		 * The meta object literal for the '{@link pepper.peppermm.impl.DependencyLinkImpl <em>Dependency Link</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.DependencyLinkImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getDependencyLink()
		 * @generated
		 */
        EClass DEPENDENCY_LINK = eINSTANCE.getDependencyLink();

        /**
		 * The meta object literal for the '<em><b>Target Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute DEPENDENCY_LINK__TARGET_KIND = eINSTANCE.getDependencyLink_TargetKind();

        /**
		 * The meta object literal for the '<em><b>Source Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EAttribute DEPENDENCY_LINK__SOURCE_KIND = eINSTANCE.getDependencyLink_SourceKind();

        /**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
         * end-user-doc -->
		 * @generated
		 */
        EReference DEPENDENCY_LINK__SOURCE = eINSTANCE.getDependencyLink_Source();

        /**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_LINK__DELAY = eINSTANCE.getDependencyLink_Delay();

								/**
		 * The meta object literal for the '{@link pepper.peppermm.DependencyRelatedObject <em>Dependency Related Object</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.DependencyRelatedObject
		 * @see pepper.peppermm.impl.PepperPackageImpl#getDependencyRelatedObject()
		 * @generated
		 */
        EClass DEPENDENCY_RELATED_OBJECT = eINSTANCE.getDependencyRelatedObject();

        /**
         * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference DEPENDENCY_RELATED_OBJECT__DEPENDENCIES = eINSTANCE.getDependencyRelatedObject_Dependencies();

        /**
		 * The meta object literal for the '{@link pepper.peppermm.impl.UnavailabilityPeriodImpl <em>Unavailability Period</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see pepper.peppermm.impl.UnavailabilityPeriodImpl
		 * @see pepper.peppermm.impl.PepperPackageImpl#getUnavailabilityPeriod()
		 * @generated
		 */
		EClass UNAVAILABILITY_PERIOD = eINSTANCE.getUnavailabilityPeriod();

								/**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNAVAILABILITY_PERIOD__START_DATE = eINSTANCE.getUnavailabilityPeriod_StartDate();

								/**
		 * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNAVAILABILITY_PERIOD__END_DATE = eINSTANCE.getUnavailabilityPeriod_EndDate();

								/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNAVAILABILITY_PERIOD__DESCRIPTION = eINSTANCE.getUnavailabilityPeriod_Description();

								/**
		 * The meta object literal for the '{@link pepper.peppermm.WorkpackageArtefactNature <em>Workpackage Artefact Nature</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.WorkpackageArtefactNature
		 * @see pepper.peppermm.impl.PepperPackageImpl#getWorkpackageArtefactNature()
		 * @generated
		 */
        EEnum WORKPACKAGE_ARTEFACT_NATURE = eINSTANCE.getWorkpackageArtefactNature();

        /**
         * The meta object literal for the '{@link StartOrEnd <em>Start Or End</em>}' enum. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see StartOrEnd
         * @see pepper.peppermm.impl.PepperPackageImpl#getStartOrEnd()
         * @generated
         */
        EEnum START_OR_END = eINSTANCE.getStartOrEnd();

        /**
		 * The meta object literal for the '{@link pepper.peppermm.TaskTimeBoundariesConstraint <em>Task Time Boundaries Constraint</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see pepper.peppermm.TaskTimeBoundariesConstraint
		 * @see pepper.peppermm.impl.PepperPackageImpl#getTaskTimeBoundariesConstraint()
		 * @generated
		 */
        EEnum TASK_TIME_BOUNDARIES_CONSTRAINT = eINSTANCE.getTaskTimeBoundariesConstraint();

        /**
         * The meta object literal for the '{@link RiskKind <em>Risk Kind</em>}' enum. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see RiskKind
         * @see pepper.peppermm.impl.PepperPackageImpl#getRiskKind()
         * @generated
         */
        EEnum RISK_KIND = eINSTANCE.getRiskKind();

        /**
         * The meta object literal for the '{@link RiskState <em>Risk State</em>}' enum. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see RiskState
         * @see pepper.peppermm.impl.PepperPackageImpl#getRiskState()
         * @generated
         */
        EEnum RISK_STATE = eINSTANCE.getRiskState();

        /**
         * The meta object literal for the '{@link ProjectState <em>Project State</em>}' enum. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see ProjectState
         * @see pepper.peppermm.impl.PepperPackageImpl#getProjectState()
         * @generated
         */
        EEnum PROJECT_STATE = eINSTANCE.getProjectState();

        /**
		 * The meta object literal for the '<em>Instant</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see java.time.Instant
		 * @see pepper.peppermm.impl.PepperPackageImpl#getInstant()
		 * @generated
		 */
        EDataType INSTANT = eINSTANCE.getInstant();

        /**
		 * The meta object literal for the '<em>Date</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see java.time.LocalDate
		 * @see pepper.peppermm.impl.PepperPackageImpl#getDate()
		 * @generated
		 */
        EDataType DATE = eINSTANCE.getDate();

    }

} // PepperPackage
