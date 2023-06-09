package c.g.f

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    FirebaseApp.initializeApp(/*context=*/this)

    val firebaseAppCheck = FirebaseAppCheck.getInstance()
    firebaseAppCheck.installAppCheckProviderFactory(
      PlayIntegrityAppCheckProviderFactory.getInstance()
    )

    val timestamp = System.currentTimeMillis()
    val database = Firebase.database
    database.getReference("message").setValue(timestamp)

    Log.d("yifany", "wrote to rtdb: $timestamp")
    Toast.makeText(this, "hello: $timestamp", Toast.LENGTH_LONG).show()
  }
}
