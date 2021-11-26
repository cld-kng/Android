package com.sg.diceroll;

import com.example.diceroll.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dice);

		// set imageview vars for default image
		ImageView startImageOne = (ImageView) findViewById(R.id.dice_image_one);
		ImageView startImageTwo = (ImageView) findViewById(R.id.dice_image_two);

		// set default dice images
		startImageOne.setImageResource(R.drawable.start_image);
		startImageTwo.setImageResource(R.drawable.start_image);

	}

	// dice view show
	// change image based on dice value parsed
	public void Show(int diceValue, ImageView diceImage) {
		switch (diceValue) {
		case 1:
			diceImage.setImageResource(R.drawable.dice1);
			break;
		case 2:
			diceImage.setImageResource(R.drawable.dice2);
			break;
		case 3:
			diceImage.setImageResource(R.drawable.dice3);
			break;
		case 4:
			diceImage.setImageResource(R.drawable.dice4);
			break;
		case 5:
			diceImage.setImageResource(R.drawable.dice5);
			break;
		case 6:
			diceImage.setImageResource(R.drawable.dice6);
			break;
		}
	}

	public void rollDice(View v) {

		// dice roll limit
		int upperLimit = 6;

		TextView diceResultText = (TextView) findViewById(R.id.textResult);
		TextView diceResultTextMsg = (TextView) findViewById(R.id.textResultMsg);
		EditText userGuessInput = (EditText) findViewById(R.id.userNumber);
		String inputCheck = userGuessInput.getText().toString().trim();

		// error checking
		// only accept numbers 2-12
		try {
			int inputNumCheck = Integer.parseInt(inputCheck);
			if (inputCheck.isEmpty() || inputCheck.length() == 0
					|| inputNumCheck < 2 || inputNumCheck > 12
					|| inputCheck.equals("") || inputCheck == null) {
				diceResultTextMsg.setText("Please enter a valid number");
			} else {

				// parse input as int
				int userGuess = Integer.parseInt(String.valueOf(userGuessInput
						.getText()));

				// random number for each dice
				int randomNumber1 = (int) ((Math.random() * upperLimit) + 1);
				int randomNumber2 = (int) ((Math.random() * upperLimit) + 1);
				// combine both random numbers
				int diceRollTotal = randomNumber1 + randomNumber2;

				// set dice total
				diceResultText.setText("Dice Total:" + diceRollTotal);

				// set dice roll history
				TextView textDiceHistory = (TextView) findViewById(R.id.textDiceHistory);

				textDiceHistory.append(diceRollTotal + " , ");

				ImageView diceOne = (ImageView) findViewById(R.id.dice_image_one);
				ImageView diceTwo = (ImageView) findViewById(R.id.dice_image_two);

				//change dice images
				Show(randomNumber1, diceOne);
				Show(randomNumber2, diceTwo);

				//check if user had guessed correct #
				if (userGuess == diceRollTotal) {
					diceResultTextMsg.setText("Congratulations");
				} else {
					diceResultTextMsg.setText("Not a match");
				}
			}
		} catch (NumberFormatException nfe) {
			diceResultTextMsg.setText("Please enter a valid number");
		}

	} // end of rollDice

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dice, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
