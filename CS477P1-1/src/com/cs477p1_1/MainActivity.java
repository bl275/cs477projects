package com.cs477p1_1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
	Button buttonAdd, buttonSub, buttonMult, buttonDiv;
	Button buttonEquals, buttonClear, buttonClearEverything, buttonDecimel;
	
	TextView tv_result;
	
	double number1 = 0, number2 = 0, tempNumber = 0;
	// 0 +  1 -  2 *  3 /
	int op = -1;
	
	boolean decimel = false;
	int decDigit = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv_result = (TextView)findViewById(R.id.tv_result);
		
		button0 = (Button)findViewById(R.id.button0);
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		button5 = (Button)findViewById(R.id.button5);
		button6 = (Button)findViewById(R.id.button6);
		button7 = (Button)findViewById(R.id.button7);
		button8 = (Button)findViewById(R.id.button8);
		button9 = (Button)findViewById(R.id.button9);
		
		buttonAdd  = (Button)findViewById(R.id.buttonAdd);
		buttonSub  = (Button)findViewById(R.id.buttonSub);
		buttonMult = (Button)findViewById(R.id.buttonMult);
		buttonDiv  = (Button)findViewById(R.id.buttonDiv);
		
		buttonEquals 			= (Button)findViewById(R.id.buttonEquals);
		buttonClear 			= (Button)findViewById(R.id.buttonClear);
		buttonClearEverything	= (Button)findViewById(R.id.buttonClearEverything);
		buttonDecimel		    = (Button)findViewById(R.id.buttonDecimel);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onButtonPress(View v) {
		switch(v.getId()) {
		case R.id.button0:
			addToCurrent(0);
			break;
		case R.id.button1:
			addToCurrent(1);
			break;
		case R.id.button2:
			addToCurrent(2);
			break;
		case R.id.button3:
			addToCurrent(3);
			break;
		case R.id.button4:
			addToCurrent(4);
			break;
		case R.id.button5:
			addToCurrent(5);
			break;
		case R.id.button6:
			addToCurrent(6);
			break;
		case R.id.button7:
			addToCurrent(7);
			break;
		case R.id.button8:
			addToCurrent(8);
			break;
		case R.id.button9:
			addToCurrent(9);
			break;
		case R.id.buttonAdd:
			number1 = tempNumber;
			tempNumber = 0;
			op = 0;
			decimel = false;
			decDigit = 1;
			break;
		case R.id.buttonSub:
			number1 = tempNumber;
			tempNumber = 0;
			op = 1;
			decimel = false;
			decDigit = 1;
			break;			
		case R.id.buttonMult:
			number1 = tempNumber;
			tempNumber = 0;
			op = 2;
			decimel = false;
			decDigit = 1;
			break;			
		case R.id.buttonDiv:
			number1 = tempNumber;
			tempNumber = 0;
			op = 3;
			decimel = false;
			decDigit = 1;
			break;			
		case R.id.buttonEquals:
			number2 = tempNumber;
			double answer = 0;
			switch (op) {
			case -1:
				answer = tempNumber;
				break;
			case 0:
				answer = number1 + number2;
				break;
			case 1:
				answer = number1 - number2;
				break;
			case 2:
				answer = number1 * number2;
				break;
			case 3:
				answer = number1 / number2;
				break;
			}
			tv_result.setText(answer+"");
			number2 = 0;
			number1 = 0;
			tempNumber = 0;
			decimel = false;
			decDigit = 1;
			break;
		case R.id.buttonClearEverything:
			number1 = 0;
			number2 = 0;
			tempNumber = 0;
			tv_result.setText(tempNumber+"");
			break;
		case R.id.buttonClear:
			number2 = Math.floor(tempNumber / 10);
			tv_result.setText(tempNumber+"");
			break;
		case R.id.buttonDecimel:
			decimel = true;
			Log.d("PLS", "Decimel mode!");
			break;
		}
	}
	
	public void addToCurrent(double num) {
		if(!decimel) {
			tempNumber *= 10;
			tempNumber += num;
		}
		else {
			decDigit += 1;
			Log.d("Decimel", Math.pow(10, decDigit)+"");
			num /= Math.pow(10, decDigit);
			tempNumber += num;
		}
		tv_result.setText(tempNumber+"");
	}

}
