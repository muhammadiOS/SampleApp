package attendance.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import common.theme.SampleAppTheme

class AttendanceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    AttendanceScreen(
                        modifier = Modifier
                            .padding(paddingValues)
                    )
                }
            }
        }
    }
}


