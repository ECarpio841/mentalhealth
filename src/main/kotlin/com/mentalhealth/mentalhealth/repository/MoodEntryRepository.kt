import com.mentalhealth.mentalhealth.entity.MoodEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MoodEntryRepository : JpaRepository<MoodEntry, Long>
