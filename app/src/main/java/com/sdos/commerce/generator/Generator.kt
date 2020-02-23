package com.sdos.commerce.generator

import com.sdos.commerce.entities.*

object Generator {

    fun getEmployees() = listOf(
        Employee(null, "Antonio", "Molino Fernandez", "amolino@gmail.com",0, "677889933", "1234", 0.0, 0, listOf(), -1, "https://idatosabiertos.org/wp-content/uploads/2017/04/juanpane.png"),
        Employee(null, "Julio", "Aparicio Matías", "japaricio@gmail.com",1, "677889933", "1234", 0.0, 0, listOf(), -1, "https://upload.wikimedia.org/wikipedia/commons/b/b7/Juan_Darth%C3%A9s_.png"),
        Employee(null, "Miguel", "Lopez Estevez", "mploez@gmail.com",1, "677889933", "1234", 0.0, 0, listOf(), -1, "https://etfsantpau.com/wp-content/uploads/2019/03/Docentes_v2_0017_Juan-Luis-Linares-1.jpg"),
        Employee(null, "Alberto", "Espejo Gonzalez", "aespejo@gmail.com",1, "677889933", "1234", 0.0, 0, listOf(), -1, "https://www.bde.es/f/webpi/SES/staff/jimenoserranojuanfrancisco/files/jimenojuanfrancisco.jpg"))

    fun getSkills() = listOf(
        Skill(null, "Cobrador"),
        Skill(null, "Reponedor"),
        Skill(null, "Mensajero"),
        Skill(null, "Mecánico")
    )

    fun getTasks() = listOf(
        Task(null, "Cambiar pantalla portatil", "Se necesita realizar un cambio de pantalla en un portatil debido a una caída", 0.5, 4, null)
    )

    fun getTypeEmployee() = listOf(
        TypeEmployee(null, "Administrador"),
        TypeEmployee(null, "Técnico")
    )

    fun getTypeTask() = listOf(
        TypeTask(null, "Cobrar", listOf(0)),
        TypeTask(null, "Envolver", listOf(1,2)),
        TypeTask(null, "Reponer", listOf(1)),
        TypeTask(null, "Enviar", listOf(2)),
        TypeTask(null, "Arreglar", listOf(3))
        )

}

