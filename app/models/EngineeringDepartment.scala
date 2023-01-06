package models

import common.AppConstants

case class EngineeringDepartment() extends Department {
    override val departmentName: String = AppConstants.ENGINEERING_DEPARTMENT
}
