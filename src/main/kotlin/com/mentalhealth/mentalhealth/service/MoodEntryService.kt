import com.mentalhealth.mentalhealth.dto.MoodEntryDto
import com.mentalhealth.mentalhealth.entity.MoodEntry
import com.mentalhealth.mentalhealth.entity.Users
import com.mentalhealth.mentalhealth.repository.UsersRepository
import org.springframework.stereotype.Service

@Service
class MoodEntryService(
    private val moodEntryRepository: MoodEntryRepository,
    private val userRepository: UsersRepository
) {

    fun getAllMoodEntries(): List<MoodEntry> {
        return moodEntryRepository.findAll()
    }

    fun createMoodEntry(moodEntryDTO: MoodEntryDto): MoodEntry {
        val user: Users = userRepository.findById(1L).orElseThrow { IllegalArgumentException("User not found") }

        val moodEntry = MoodEntry(
            users = user,
            mood = moodEntryDTO.mood,
        )

        return moodEntryRepository.save(moodEntry)
    }
}
