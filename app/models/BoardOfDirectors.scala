package models

import common.AppConstants

case class BoardOfDirectors() extends Department {
    override val departmentName: String = AppConstants.BOARD_OF_DIRECTORS
}
