package services

import models._
import javax.inject._
import common.AppConstants

@Singleton
class EmployeeService @Inject() {
  private val boardOfDirectors = new BoardOfDirectors
  private val serviceDepartment = new ServiceDepartment
  private val operationsDepartment = new OperationsDepartment
  private val engineeringDepartment = new EngineeringDepartment

  def addEmployee(employee: Employee, department: String): Boolean = {
    department match {
      case AppConstants.BOARD_OF_DIRECTORS => boardOfDirectors.addEmployee(employee)
      case AppConstants.SERVICE_DEPARTMENT => serviceDepartment.addEmployee(employee)
      case AppConstants.OPERATIONS_DEPARTMENT => operationsDepartment.addEmployee(employee)
      case AppConstants.ENGINEERING_DEPARTMENT => engineeringDepartment.addEmployee(employee)
    }
  }

  def removeEmployee(employee: Employee, department: String): Boolean = {
    department match {
      case AppConstants.BOARD_OF_DIRECTORS => boardOfDirectors.removeEmployee(employee)
      case AppConstants.SERVICE_DEPARTMENT => serviceDepartment.removeEmployee(employee)
      case AppConstants.OPERATIONS_DEPARTMENT => operationsDepartment.removeEmployee(employee)
      case AppConstants.ENGINEERING_DEPARTMENT => engineeringDepartment.removeEmployee(employee)
    }
  }

  def getEldestEmployee(department: String): Employee = {
    department match {
      case AppConstants.BOARD_OF_DIRECTORS => boardOfDirectors.getEldestEmployee()
      case AppConstants.SERVICE_DEPARTMENT => serviceDepartment.getEldestEmployee()
      case AppConstants.OPERATIONS_DEPARTMENT => operationsDepartment.getEldestEmployee()
      case AppConstants.ENGINEERING_DEPARTMENT => engineeringDepartment.getEldestEmployee()
    }
  }

  def getYoungestEmployee(department: String): Employee = {
    department match {
      case AppConstants.BOARD_OF_DIRECTORS => boardOfDirectors.getYoungestEmployee()
      case AppConstants.SERVICE_DEPARTMENT => serviceDepartment.getYoungestEmployee()
      case AppConstants.OPERATIONS_DEPARTMENT => operationsDepartment.getYoungestEmployee()
      case AppConstants.ENGINEERING_DEPARTMENT => engineeringDepartment.getYoungestEmployee()
    }
  }

  def totalEmployeeAge(department: String): Int = {
    department match {
      case AppConstants.BOARD_OF_DIRECTORS => boardOfDirectors.totalEmployeeAge()
      case AppConstants.SERVICE_DEPARTMENT => serviceDepartment.totalEmployeeAge()
      case AppConstants.OPERATIONS_DEPARTMENT => operationsDepartment.totalEmployeeAge()
      case AppConstants.ENGINEERING_DEPARTMENT => engineeringDepartment.totalEmployeeAge()
    }
  }

  def averageEmployeeAge(department: String): Int = {
    department match {
      case AppConstants.BOARD_OF_DIRECTORS => boardOfDirectors.averageEmployeeAge()
      case AppConstants.SERVICE_DEPARTMENT => serviceDepartment.averageEmployeeAge()
      case AppConstants.OPERATIONS_DEPARTMENT => operationsDepartment.averageEmployeeAge()
      case AppConstants.ENGINEERING_DEPARTMENT => engineeringDepartment.averageEmployeeAge()
    }
  }
  
  def totalEmployeeAge(): Int = {
    boardOfDirectors.totalEmployeeAge() + serviceDepartment.totalEmployeeAge() 
    + operationsDepartment.totalEmployeeAge() + engineeringDepartment.totalEmployeeAge()
  }

  def averageEmployeeAge(): Int = {
    val totalEmployeeCount: Int = boardOfDirectors.getTotalEmployee() + serviceDepartment.getTotalEmployee()
                                + operationsDepartment.getTotalEmployee() + engineeringDepartment.getTotalEmployee()    
                        
    this.totalEmployeeAge() / totalEmployeeCount
  }

  def availableVacancy(department: String): Int = {
    department match {
      case AppConstants.BOARD_OF_DIRECTORS => boardOfDirectors.availableVacancy()
      case AppConstants.SERVICE_DEPARTMENT => serviceDepartment.availableVacancy()
      case AppConstants.OPERATIONS_DEPARTMENT => operationsDepartment.availableVacancy()
      case AppConstants.ENGINEERING_DEPARTMENT => engineeringDepartment.availableVacancy()
    }
  }
}

