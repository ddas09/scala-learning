package models

import common.AppConstants

case class OperationsDepartment() extends Department {
    override val departmentName: String = AppConstants.OPERATIONS_DEPARTMENT
}
