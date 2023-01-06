package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models._
import services._
import common.AppConstants
import play.api.libs._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class EmployeeController @Inject()(val employeeService: EmployeeService, val controllerComponents: ControllerComponents) extends BaseController {
  
  private val engineers = List[Employee] (
    new Employee("Gnanaraj", 34),
    new Employee("Dipankar", 22),
    new Employee("Rohan", 23),
    new Employee("Ashish", 30),
    new Employee("Mohd", 29),
    new Employee("Nitesh", 26),
    new Employee("Naman", 23)
  )
  engineers.foreach(engineer => employeeService.addEmployee(engineer, AppConstants.ENGINEERING_DEPARTMENT))

  private val directors = List[Employee] (
    new Employee("Jeet", 54),
    new Employee("Sandeep", 50),
    new Employee("Vijaya", 46),
    new Employee("Sunil", 43),
    new Employee("Rakesh", 46)
  )
  directors.foreach(director => employeeService.addEmployee(director, AppConstants.BOARD_OF_DIRECTORS))

  private val operationTeam = List[Employee] (
    new Employee("Tapish", 35),
    new Employee("Ayush", 34),
    new Employee("Surrendra", 45),
    new Employee("Ashi", 25),
    new Employee("Vikash", 29)
  )
  operationTeam.foreach(member => employeeService.addEmployee(member, AppConstants.OPERATIONS_DEPARTMENT))

  private val serviceTeam = List[Employee] (
    new Employee("Ankit", 22),
    new Employee("Ghanshyam", 30),
    new Employee("Mukesh", 42),
    new Employee("Bhanu", 22),
  )
  serviceTeam.foreach(member => employeeService.addEmployee(member, AppConstants.SERVICE_DEPARTMENT))

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok("")
  }

  def getEledestEmployee(department: String) = Action { implicit request: Request[AnyContent] =>
    val eldestEmployee = employeeService.getEldestEmployee(department)
    Ok(eldestEmployee.toString())
  }

  def getYoungestEmployee(department: String) = Action { implicit request: Request[AnyContent] =>
    val youngestEmployee = employeeService.getYoungestEmployee(department)
    Ok(youngestEmployee.toString())
  }

  def getTotalAge(department: String) = Action { implicit request: Request[AnyContent] =>
    val totalAge = employeeService.totalEmployeeAge(department)
    Ok(s"Total age is: $totalAge")
  }
}
