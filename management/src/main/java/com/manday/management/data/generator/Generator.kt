package com.manday.coredata.generator

object Generator {

    fun getEmployees() = listOf(
        EmployeeEntity(null, "Ruben", "García", "amolino@gmail.com",0, "677889933", "1234", 0.0, 0, listOf(), -1, "https://idatosabiertos.org/wp-content/uploads/2017/04/juanpane.png", "12/3/77"),
        EmployeeEntity(null, "Rafael", "Martín", "rmartino@gmail.com",1, "677889933", "1234", 0.0, 2, listOf(), -1, "https://upload.wikimedia.org/wikipedia/commons/b/b7/Juan_Darth%C3%A9s_.png", "24/11/80"),
        EmployeeEntity(null, "Sara", "López", "sploez@gmail.com",1, "677889933", "1234", 0.0, 1, listOf(), -1, "https://etfsantpau.com/wp-content/uploads/2019/03/Docentes_v2_0017_Juan-Luis-Linares-1.jpg", "2/8/90")
    )

    fun getSkills() = listOf(
        com.manday.management.data.entities.SkillEntity(null, "Cobrador"),
        com.manday.management.data.entities.SkillEntity(null, "Reponedor"),
        com.manday.management.data.entities.SkillEntity(null, "Mensajero"),
        com.manday.management.data.entities.SkillEntity(null, "Mecánico")
    )

    fun getTasks() = listOf(
        com.manday.management.data.entities.TaskEntity(
            null,
            "Cambiar pantalla portatil",
            "Se necesita realizar un cambio de pantalla en un portatil debido a una caída",
            0.3,
            4,
            null,
            "https://img.milanuncios.com/fg/2664/30/266430484_1.jpg?VersionId=WgwgSsXSXZEY_jXNjzzLbiuQKgVxAx4W"
        ),
        com.manday.management.data.entities.TaskEntity(
            null,
            "Instalar batería",
            "Se debe realizar el cambio de alimentación para la batería de un portatil Acer SP12-4",
            0.3,
            4,
            null,
            "https://www.tel2u.com/951789/bateria-para-laptop-para-dell.jpg"
        ),
        com.manday.management.data.entities.TaskEntity(
            null,
            "Configurar consola",
            "Se necesita configurar el nuevo firmware de una Play Station 4",
            0.3,
            4,
            null,
            "https://media.ldlc.com/r1600/ld/products/00/03/83/27/LD0003832755_2.jpg"
        )
    )

    fun getTypeEmployee() = listOf(
        com.manday.management.data.entities.TypeEmployeeEntity(
            null,
            "Administrador"
        ),
        com.manday.management.data.entities.TypeEmployeeEntity(null, "Técnico")
    )

    fun getTypeTask() = listOf(
        com.manday.management.data.entities.TypeTaskEntity(
            null,
            "Cobrar",
            listOf(0)
        ),
        com.manday.management.data.entities.TypeTaskEntity(
            null,
            "Envolver",
            listOf(1, 2)
        ),
        com.manday.management.data.entities.TypeTaskEntity(
            null,
            "Reponer",
            listOf(1)
        ),
        com.manday.management.data.entities.TypeTaskEntity(
            null,
            "Enviar",
            listOf(2)
        ),
        com.manday.management.data.entities.TypeTaskEntity(
            null,
            "Arreglar",
            listOf(3)
        )
    )
}

