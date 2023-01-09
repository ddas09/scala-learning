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

  private def getDepartmentByName(departmentName: String): Option[Department] = {
    departmentName match {
      case AppConstants.BOARD_OF_DIRECTORS => Some(boardOfDirectors)
      case AppConstants.SERVICE_DEPARTMENT => Some(serviceDepartment)
      case AppConstants.OPERATIONS_DEPARTMENT => Some(operationsDepartment)
      case AppConstants.ENGINEERING_DEPARTMENT => Some(engineeringDepartment)
      case _ => None
    }
  }

  def addEmployee(employee: Employee, departmentName: String): Boolean = {
    val department = this.getDepartmentByName(departmentName)
    if (department.isEmpty) false else department.get.addEmployee(employee)
  }

  def removeEmployee(employee: Employee, departmentName: String): Boolean = {
    val department = this.getDepartmentByName(departmentName)
    if (department.isEmpty) false else department.get.removeEmployee(employee)
  }

  def getEldestEmployee(departmentName: String): Option[Employee] = {
    val department = this.getDepartmentByName(departmentName)
    if (department.isEmpty) None else Some(department.get.getEldestEmployee())
  }

  def getYoungestEmployee(departmentName: String): Option[Employee] = {
    val department = this.getDepartmentByName(departmentName)
    if (department.isEmpty) None else Some(department.get.getYoungestEmployee())
  }

  def totalEmployeeAge(departmentName: String): Option[Int] = {
    val department = this.getDepartmentByName(departmentName)
    if (department.isEmpty) None else Some(department.get.totalEmployeeAge())
  }

  def totalEmployeeAge(): Int = {
    boardOfDirectors.totalEmployeeAge() + serviceDepartment.totalEmployeeAge() 
    + operationsDepartment.totalEmployeeAge() + engineeringDepartment.totalEmployeeAge()
  }

  def averageEmployeeAge(departmentName: String): Option[Int] = {
    val department = this.getDepartmentByName(departmentName)
    if (department.isEmpty) None else Some(department.get.averageEmployeeAge())
  }
  
  def averageEmployeeAge(): Int = {
    val totalEmployeeCount: Int = boardOfDirectors.getTotalEmployee() + serviceDepartment.getTotalEmployee()
                                + operationsDepartment.getTotalEmployee() + engineeringDepartment.getTotalEmployee()    
                        
    this.totalEmployeeAge() / totalEmployeeCount
  }

  def availableVacancy(departmentName: String): Option[Int] = {
    val department = this.getDepartmentByName(departmentName)
    if (department.isEmpty) None else Some(department.get.availableVacancy())
  }

  def recommendedDirectors(): List[Employee] = {
    val recommendedEngineers = engineeringDepartment.employees
      .filter(employee => employee.age > AppConstants.DIRECTOR_QUALIFICATION_AGE)

    val recommendedOperationTeamMembers = operationsDepartment.employees
      .filter(employee => employee.age > AppConstants.DIRECTOR_QUALIFICATION_AGE)

    val recommendedDirectors = recommendedEngineers ++ recommendedOperationTeamMembers

    recommendedDirectors.toList
  }
}

