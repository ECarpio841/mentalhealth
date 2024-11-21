package com.mentalhealth.mentalhealth.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "mood_entries")
class MoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    var users: Users? = null

    var mood: String = ""

    constructor()

    constructor(users: Users, mood: String) {
        this.users = users
        this.mood = mood
    }
}