package com.mentalhealth.mentalhealth.entity

import jakarta.persistence.*

@Entity
@Table(name = "mood_entries")
class MoodEntry(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val users: Users,
    val mood: String,

)