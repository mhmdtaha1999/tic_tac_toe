package com.example.tictactoe

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tictactoe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    public lateinit var binding : ActivityMainBinding
    var player1turn:Boolean = true
    var countofPlayerXwin:Int = 0
    var countofPlayerOWin:Int = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        player1turn = randomTurn()
        if (player1turn){
            binding.txtTurn.text = "Turn Player X"
            binding.txtTurn.setTextColor(Color.GREEN)
        }
        else {
            binding.txtTurn.text="Turn Player O"
            binding.txtTurn.setTextColor(Color.RED)
        }



       binding.b1.setOnClickListener {
          btnClicked(binding.b1)
           checkWin()
       }
        binding.b2.setOnClickListener {
            btnClicked(binding.b2)
            checkWin()
        }
        binding.b3.setOnClickListener {
            btnClicked(binding.b3)
            checkWin()
        }
        binding.b4.setOnClickListener {
            btnClicked(binding.b4)
            checkWin()
        }
        binding.b5.setOnClickListener {
            btnClicked(binding.b5)
            checkWin()
        }
        binding.b6.setOnClickListener {
            btnClicked(binding.b6)
            checkWin()
        }
        binding.b7.setOnClickListener {
            btnClicked(binding.b7)
            checkWin()
        }
        binding.b8.setOnClickListener {
            btnClicked(binding.b8)
            checkWin()
        }
        binding.b9.setOnClickListener {
            btnClicked(binding.b9)
            checkWin()
        }
        binding.imgbtnreset.setOnClickListener {
            enableBtn()
            clearbtn()
        }
        binding.btnreset.setOnClickListener {
            enableBtn()
            countofPlayerOWin = 0
            countofPlayerXwin = 0
            binding.countplayer2.text = "Player O"
            binding.countplayer1.text = "Player X"
        }
    }
    private fun btnClicked(btn:Button) : Unit{
        if(btn.text == ""){
            if (player1turn){
                btn.text = "X"
                btn.setTextColor(Color.GREEN)
                player1turn = false
                binding.txtTurn.text = "Turn Player O"
            }
            else{
                btn.text = "O"
                btn.setTextColor(Color.RED)
                player1turn = true
                binding.txtTurn.text = "Turn Player X"
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun randomTurn():Boolean{
        val rnd = (0..1).random()
        return rnd == 1
    }
    fun checkWin(){
        if(    (binding.b1.text=="X" && binding.b2.text=="X" && binding.b3.text=="X")
            || (binding.b4.text=="X" && binding.b5.text=="X" && binding.b6.text=="X")
            || (binding.b7.text=="X" && binding.b8.text=="X" && binding.b9.text=="X")
            || (binding.b1.text=="X" && binding.b5.text=="X" && binding.b9.text=="X")
            || (binding.b3.text=="X" && binding.b5.text=="X" && binding.b7.text=="X")
            || (binding.b1.text=="X" && binding.b4.text=="X" && binding.b7.text=="X")
            || (binding.b2.text=="X" && binding.b5.text=="X" && binding.b8.text=="X")
            || (binding.b3.text=="X" && binding.b6.text=="X" && binding.b9.text=="X")){
            Toast.makeText(this,"Player X Won", Toast.LENGTH_SHORT)
            countofPlayerXwin++
            binding.countplayer1.text = countofPlayerXwin.toString()
            disablebtn()
            Toast.makeText(this,"Player X Won the Game ",Toast.LENGTH_LONG).show()

        }else if ((binding.b1.text=="O" && binding.b2.text=="O" && binding.b3.text=="O")
            || (binding.b4.text=="O" && binding.b5.text=="O" && binding.b6.text=="O")
            || (binding.b7.text=="O" && binding.b8.text=="O" && binding.b9.text=="O")
            || (binding.b1.text=="O" && binding.b5.text=="O" && binding.b9.text=="O")
            || (binding.b3.text=="O" && binding.b5.text=="O" && binding.b7.text=="O")
            || (binding.b1.text=="O" && binding.b4.text=="O" && binding.b7.text=="O")
            || (binding.b2.text=="O" && binding.b5.text=="O" && binding.b8.text=="O")
            || (binding.b3.text=="O" && binding.b6.text=="O" && binding.b9.text=="O")){

            Toast.makeText(this,"Player O Won", Toast.LENGTH_SHORT)
            countofPlayerOWin++
            binding.countplayer2.text = countofPlayerOWin.toString()
            Toast.makeText(this,"Player O Won the Game ",Toast.LENGTH_LONG).show()
            disablebtn()

        } else if(binding.b1.text != "" && binding.b2.text != "" && binding.b3.text != "" && binding.b4.text != ""
            && binding.b5.text != ""&& binding.b6.text != "" && binding.b7.text != ""&& binding.b8.text != ""
            && binding.b9.text != "" )   {
            Toast.makeText(this,"Draw",Toast.LENGTH_LONG).show()
            disablebtn()
        }
    }

    fun clearbtn(){
        binding.b1.text =""
        binding.b2.text =""
        binding.b3.text =""
        binding.b4.text =""
        binding.b5.text =""
        binding.b6.text =""
        binding.b7.text =""
        binding.b8.text =""
        binding.b9.text =""
    }
    fun disablebtn(){
        binding.b1.isEnabled = false
        binding.b2.isEnabled = false
        binding.b3.isEnabled = false
        binding.b4.isEnabled = false
        binding.b5.isEnabled = false
        binding.b6.isEnabled = false
        binding.b7.isEnabled = false
        binding.b8.isEnabled = false
        binding.b9.isEnabled = false
    }

    fun enableBtn(){
        binding.b1.isEnabled = true
        binding.b2.isEnabled = true
        binding.b3.isEnabled = true
        binding.b4.isEnabled = true
        binding.b5.isEnabled = true
        binding.b6.isEnabled = true
        binding.b7.isEnabled = true
        binding.b8.isEnabled = true
        binding.b9.isEnabled = true
    }
}