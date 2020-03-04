package com.sdos.commerce.data.datasource.database

import androidx.lifecycle.LiveData
import com.sdos.commerce.dao.*
import com.sdos.commerce.data.datasource.EmployeeDatabaseDataSource
import com.sdos.commerce.data.datasource.FruitDatabaseDataSource
import com.sdos.commerce.data.datasource.SkillDatabaseDataSource
import com.sdos.commerce.data.datasource.TaskDatabaseDataSource
import com.sdos.commerce.data.room.CommerceDatabase
import com.sdos.commerce.entities.*


class RoomController: EmployeeDatabaseDataSource, TaskDatabaseDataSource, SkillDatabaseDataSource, FruitDatabaseDataSource {

    private var db: CommerceDatabase? = null
    private var employeeDao: EmployeeDao? = null
    private var taskDao: TaskDao? = null
    private var skillDao: SkillDao? = null
    private var typeTaskDao: TypeTaskDao? = null
    private var fruitDao: FruitDao? = null

    init {
        db = CommerceDatabase.getInstance()
        employeeDao = db?.employeeDao()
        taskDao = db?.taskDao()
        skillDao = db?.skillDao()
        typeTaskDao = db?.typeTaskDao()
        fruitDao = db?.fruitDao()
    }


    override fun login(param1: String, param2: String): LiveData<Employee>?  {
        return employeeDao?.getEmployee(param1, param2, 0)
    }

    override fun getEmployees(): LiveData<List<Employee>>? {
        return employeeDao?.getAllEmployees()
    }

    override fun getTasks(): LiveData<List<Task>>? {
        return taskDao?.getAllTasks()
    }

    override fun getSkillList(): LiveData<List<Skill>>? {
        return skillDao?.getAllSkills()
    }

    override fun addEmployee(employee: Employee) {
        employeeDao?.addEmployee(employee)
    }

    override fun getTypeTasks(): LiveData<List<TypeTask>>? {
        return typeTaskDao?.getAllTypeTasks()
    }

    override fun addTask(task: Task) {
        taskDao?.addTask(task)
    }

    override fun addFruits(list: List<Fruit>) {
        fruitDao?.insert(list)
    }
}