import com.mentalhealth.mentalhealth.dto.MoodEntryDto
import com.mentalhealth.mentalhealth.entity.MoodEntry
import com.mentalhealth.mentalhealth.entity.Users
import com.mentalhealth.mentalhealth.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MoodEntryService(
    private val moodEntryRepository: MoodEntryRepository,
    private val userRepository: UsersRepository
) {
    @Autowired
    lateinit var moodEntriesViewRepository: MoodEntriesViewRepository

    fun listMoodEntriesView(): List<MoodEntriesView> {
        return moodEntriesViewRepository.findAll()
    }
    fun getAllMoodEntries(): List<MoodEntry> {
        return moodEntryRepository.findAll()
    }

    fun createMoodEntry(moodEntryDTO: MoodEntryDto): MoodEntry {
        val user: Users = userRepository.findById(moodEntryDTO.userId)
            .orElseThrow { IllegalArgumentException("User not found with ID: ${moodEntryDTO.userId}") }

        val moodEntry = MoodEntry(
            users = user,
            mood = moodEntryDTO.mood
        )

        return moodEntryRepository.save(moodEntry)
    }
}
