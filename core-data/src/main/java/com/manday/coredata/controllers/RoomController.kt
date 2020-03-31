package com.manday.coredata.controllers

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.EmployeeDataSource
import com.manday.coredata.entities.EmployeeEntity
import com.sdos.commerce.dao.*
import com.sdos.commerce.data.room.CommerceDatabase


class RoomController: EmployeeDataSource {

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

    override fun login(param1: String, param2: String): LiveData<EmployeeEntity>?  {
        return employeeDao?.getEmployee(param1, param2, 0)
    }

    override fun getEmployees(): LiveData<List<EmployeeEntity>>? {
        return employeeDao?.getAllEmployees()
    }

    override fun addEmployee(employee: EmployeeEntity) {
        employeeDao?.addEmployee(employee)
    }

    /*
    override fun getTasks(): LiveData<List<Task>>? {
        return taskDao?.getAllTasks()
    }

    override fun getSkillList(): LiveData<List<Skill>>? {
        return skillDao?.getAllSkills()
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

     */
}