import jakarta.persistence.*

@Entity
@Table(name = "mood_entries_view")
class MoodEntriesView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mood_entry_id", updatable = false)
    var moodEntryId: Long? = null

    var mood: String? = null

    @Column(name = "user_id")
    var userId: Long? = null

    @Column(name = "full_name")
    var fullName: String? = null

    var email: String? = null

    var phone: String? = null
}
