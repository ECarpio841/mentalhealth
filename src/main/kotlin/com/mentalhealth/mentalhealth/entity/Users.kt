package com.mentalhealth.mentalhealth.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fullName: String? = null
    var email: String? = null

    @OneToMany(mappedBy = "users", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val moodEntries: List<MoodEntry> = emptyList()
}