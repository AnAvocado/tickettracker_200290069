package com.example.tickettracker_200290069

class Project {
    var id: String? = null
    var project_name: String? = null
    var project_description: String? = null


    constructor() {}

    constructor(id: String, name: String, description: String){
        this.id = id
        this.project_name = name
        this.project_description = description
    }
}