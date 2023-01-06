package models

import common.AppConstants

import scala.collection.mutable.ListBuffer

trait Department {
    val departmentName: String
    val employees: ListBuffer[Employee] = ListBuffer[Employee]()

    def getTotalEmployee(): Int = this.employees.length

    def addEmployee(employee: Employee): Boolean = {
        if (employees.length >= AppConstants.MAX_EMPLOYEE_COUNT) false

        val employeeExists = this.employees.contains(employee)
        if (employeeExists) false

        if (employee.age < AppConstants.MIN_EMPLOYEE_AGE) false

        employees += employee
        true        
    }

    def removeEmployee(employee: Employee): Boolean = {
        val employeeExists = this.employees.contains(employee)
        if (!employeeExists) false

        employees -= employee
        true        
    }

    def getEldestEmployee(): Employee = this.employees.maxBy(employee => employee.age)

    def getYoungestEmployee(): Employee = this.employees.minBy(employee => employee.age) 

    def totalEmployeeAge(): Int = this.employees.map(employee => employee.age).sum
    
    def averageEmployeeAge(): Int = this.totalEmployeeAge() / this.getTotalEmployee()
    
    def availableVacancy(): Int = AppConstants.MAX_EMPLOYEE_COUNT - this.getTotalEmployee()
}
