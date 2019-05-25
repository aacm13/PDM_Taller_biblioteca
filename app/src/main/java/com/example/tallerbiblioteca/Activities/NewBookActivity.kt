package com.example.tallerbiblioteca.Activities

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tallerbiblioteca.R
import kotlinx.android.synthetic.main.activity_new_book.*

class NewBookActivity : AppCompatActivity() {

    private lateinit var editTitulo: EditText
    private lateinit var editAutores: EditText
    private lateinit var editEditorial: EditText
    private lateinit var editISBN: EditText
    private lateinit var editResumen: EditText
    private lateinit var editTags: EditText
    private lateinit var bAutores: Button
    private lateinit var bTags: Button

    private var autores = ArrayList<String>()
    private var tags = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)


        getEditTexts()
        initButtons()







        //CHOOSE IMAGE BUTTON CLICK
        choose_image_button.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{
                    //permission already granted
                    pickImageFromGallery();
                }
            }
            else{
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }
    }

    fun getEditTexts(){

        editTitulo = findViewById(R.id.book_name)
        editAutores = findViewById(R.id.book_author)
        editEditorial = findViewById(R.id.book_editorial)
        editISBN = findViewById(R.id.book_isvn)
        editResumen = findViewById(R.id.book_resumen)
        editTags = findViewById(R.id.book_tags)
        bAutores = findViewById(R.id.add_author_button)
        bTags = findViewById(R.id.add_tags_button)
    }

    fun initButtons(){
        bAutores.setOnClickListener{
            autores.add(editAutores.text.toString())

            editAutores.setText("")
        }

        bTags.setOnClickListener{
            tags.add(editTags.text.toString())

            editTags.setText("")
        }
    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            book_img.setImageURI(data?.data)
        }
    }
}
