import com.mentalhealth.mentalhealth.dto.MoodEntryDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.mentalhealth.mentalhealth.entity.MoodEntry

import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping("/moods")
class MoodEntryController {
    @Autowired
    lateinit var moodEntryService: MoodEntryService

    @GetMapping("/with-users") // Ruta relativa
    fun listMoodEntriesView(): List<MoodEntriesView> {
        return moodEntryService.listMoodEntriesView()
    }

    @GetMapping
    fun getAllMoodEntries(): ResponseEntity<List<MoodEntry>>  {
        val moodEntries = moodEntryService.getAllMoodEntries()
        return if (moodEntries.isNotEmpty()) {
            ResponseEntity.ok(moodEntries)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @PostMapping
    fun createMoodEntry(@RequestBody moodEntryDTO: MoodEntryDto): ResponseEntity<MoodEntry> {
        val moodEntry = moodEntryService.createMoodEntry(moodEntryDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(moodEntry)
    }
}

