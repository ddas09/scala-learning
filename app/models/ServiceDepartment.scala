package models

import common.AppConstants

case class ServiceDepartment() extends Department {
    override val departmentName: String = AppConstants.SERVICE_DEPARTMENT
}
