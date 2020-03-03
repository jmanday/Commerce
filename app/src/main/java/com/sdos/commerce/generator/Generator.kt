package com.sdos.commerce.generator

import com.sdos.commerce.entities.*

object Generator {

    fun getEmployees() = listOf(
        Employee(null, "Antonio", "Molino Fernandez", "amolino@gmail.com",0, "677889933", "1234", 0.0, 0, listOf(), -1, "https://idatosabiertos.org/wp-content/uploads/2017/04/juanpane.png", "12/3/77"),
        Employee(null, "Julio", "Aparicio Matías", "japaricio@gmail.com",1, "677889933", "1234", 0.0, 1, listOf(), -1, "https://upload.wikimedia.org/wikipedia/commons/b/b7/Juan_Darth%C3%A9s_.png", "24/11/80"),
        Employee(null, "Miguel", "Lopez Estevez", "mploez@gmail.com",1, "677889933", "1234", 0.0, 2, listOf(), -1, "https://etfsantpau.com/wp-content/uploads/2019/03/Docentes_v2_0017_Juan-Luis-Linares-1.jpg", "2/8/90"),
        Employee(null, "Alberto", "Espejo Gonzalez", "aespejo@gmail.com",1, "677889933", "1234", 0.0, 3, listOf(), -1, "https://www.bde.es/f/webpi/SES/staff/jimenoserranojuanfrancisco/files/jimenojuanfrancisco.jpg", "15/12/77"))

    fun getSkills() = listOf(
        Skill(0, "Cobrador"),
        Skill(1, "Reponedor"),
        Skill(2, "Mensajero"),
        Skill(3, "Mecánico")
    )

    fun getTasks() = listOf(
        Task(null, "Cambiar pantalla portatil", "Se necesita realizar un cambio de pantalla en un portatil debido a una caída", 0.3, 4, null, "https://img.milanuncios.com/fg/2664/30/266430484_1.jpg?VersionId=WgwgSsXSXZEY_jXNjzzLbiuQKgVxAx4W"),
        Task(null, "Instalar batería", "Se debe realizar el cambio de alimentación para la batería de un portatil Acer SP12-4", 0.3, 4, null, "https://www.tel2u.com/951789/bateria-para-laptop-para-dell.jpg"),
        Task(null, "Configurar consola", "Se necesita configurar el nuevo firmware de una Play Station 4", 0.3, 4, null, "https://media.ldlc.com/r1600/ld/products/00/03/83/27/LD0003832755_2.jpg")
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

