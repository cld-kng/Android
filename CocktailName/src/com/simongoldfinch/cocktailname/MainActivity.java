package com.simongoldfinch.cocktailname;

import com.poly.cocktailname.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.NumberPicker;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView cockTailImage = (ImageView) findViewById(R.id.cocktailImage);
		//set max image size
		cockTailImage.setMaxWidth(240);
		cockTailImage.setMaxHeight(240);
		
		final TextView letterName = (TextView) findViewById(R.id.letterName);
		final TextView monthName = (TextView) findViewById(R.id.monthName);
		final LinearLayout cocktailNameLayout = (LinearLayout) findViewById(R.id.layout_cocktail_name);
		//load string array from resources
		final String[] alphabet = getResources().getStringArray(R.array.alphabet);
		final String[] months = getResources().getStringArray(R.array.months);
		
		NumberPicker letterPicker = (NumberPicker) findViewById(R.id.letterPicker);
		//set display values to string array loaded earlier
		letterPicker.setDisplayedValues(alphabet);
		//set our min value 
		letterPicker.setMinValue(0);
		letterPicker.setMaxValue(alphabet.length - 1);
		
		//setup function for when a value is changed on the numberpicker
		
		letterPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int letterValue) {
				
				DisplayCocktailLetterName(letterValue, letterName);
				
			}
		});
		
		NumberPicker monthPicker = (NumberPicker) findViewById(R.id.monthPicker);
		//set display values to string array loaded earlier
		monthPicker.setDisplayedValues(months);
		//set our min value
		monthPicker.setMinValue(0);
		monthPicker.setMaxValue(months.length - 1);
		
		//setup function for when a value is changed on the numberpicker
		monthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int monthValue) {
				
				DisplayCocktailMonthName(monthValue, monthName);
				DisplayCocktailImage(monthValue, cockTailImage);
				ChangeColor(monthValue, letterName, monthName, cocktailNameLayout);
				
			}


		});
		
		//set default view for activity, for improved UX
		//set to A, January, display appropriate image and change colors
		monthPicker.setValue(0);
		letterPicker.setValue(0);
		
		DisplayCocktailLetterName(0, letterName);
		DisplayCocktailMonthName(0, monthName);
		DisplayCocktailImage(0, cockTailImage);
		ChangeColor(0, letterName, monthName, cocktailNameLayout);
	
	}

	//change lettername textview text based on value parsed from numberpicker
	public void DisplayCocktailLetterName(int letterValue, TextView letterName) {
		final String[] cocktailNameLetter = getResources().getStringArray(R.array.name_letter);
		switch (letterValue) {
		case 0:
			letterName.setText(cocktailNameLetter[0]);
			break;
		case 1:
			letterName.setText(cocktailNameLetter[1]);
			break;
		case 2:
			letterName.setText(cocktailNameLetter[2]);
			break;
		case 3:
			letterName.setText(cocktailNameLetter[3]);
			break;
		case 4:
			letterName.setText(cocktailNameLetter[4]);
			break;
		case 5:
			letterName.setText(cocktailNameLetter[5]);
			break;
		case 6:
			letterName.setText(cocktailNameLetter[6]);
			break;
		case 7:
			letterName.setText(cocktailNameLetter[7]);
			break;
		case 8:
			letterName.setText(cocktailNameLetter[8]);
			break;
		case 9:
			letterName.setText(cocktailNameLetter[9]);
			break;
		case 10:
			letterName.setText(cocktailNameLetter[10]);
			break;
		case 11:
			letterName.setText(cocktailNameLetter[11]);
			break;
		case 12:
			letterName.setText(cocktailNameLetter[12]);
			break;
		case 13:
			letterName.setText(cocktailNameLetter[13]);
			break;
		case 14:
			letterName.setText(cocktailNameLetter[14]);
			break;
		case 15:
			letterName.setText(cocktailNameLetter[15]);
			break;
		case 16:
			letterName.setText(cocktailNameLetter[16]);
			break;
		case 17:
			letterName.setText(cocktailNameLetter[17]);
			break;
		case 18:
			letterName.setText(cocktailNameLetter[18]);
			break;
		case 19:
			letterName.setText(cocktailNameLetter[19]);
			break;
		case 20:
			letterName.setText(cocktailNameLetter[20]);
			break;
		case 21:
			letterName.setText(cocktailNameLetter[21]);
			break;
		case 22:
			letterName.setText(cocktailNameLetter[22]);
			break;
		case 23:
			letterName.setText(cocktailNameLetter[23]);
			break;
		case 24:
			letterName.setText(cocktailNameLetter[23]);
			break;
		case 25:
			letterName.setText(cocktailNameLetter[23]);
			break;
		default:
			letterName.setText(cocktailNameLetter[0]);
		}
	}

	//change monthname textview text based on value parsed from numberpicker
	public void DisplayCocktailMonthName(int monthValue, TextView monthName) {
		final String[] cocktailNameMonth = getResources().getStringArray(R.array.name_month);
		switch (monthValue) {
		case 0:
			monthName.setText(cocktailNameMonth[0]);
			break;
		case 1:
			monthName.setText(cocktailNameMonth[1]);
			break;
		case 2:
			monthName.setText(cocktailNameMonth[2]);
			break;
		case 3:
			monthName.setText(cocktailNameMonth[3]);
			break;
		case 4:
			monthName.setText(cocktailNameMonth[4]);
			break;
		case 5:
			monthName.setText(cocktailNameMonth[5]);
			break;
		case 6:
			monthName.setText(cocktailNameMonth[6]);
			break;
		case 7:
			monthName.setText(cocktailNameMonth[7]);
			break;
		case 8:
			monthName.setText(cocktailNameMonth[8]);
			break;
		case 9:
			monthName.setText(cocktailNameMonth[9]);
			break;
		case 10:
			monthName.setText(cocktailNameMonth[10]);
			break;
		case 11:
			monthName.setText(cocktailNameMonth[11]);
			break;
		default:
			monthName.setText(cocktailNameMonth[0]);
			break;
		}
	}
	
	//change text,layout  colors based on value parsed from numberpicker
	public void ChangeColor(int monthValue, TextView letterName, TextView monthName, LinearLayout cocktailNameLayout) {
		final int[] bg_colors = getResources().getIntArray(R.array.background_colors);
		final int[] text_colors = getResources().getIntArray(R.array.text_colors);
		switch (monthValue) {
		case 0:
			letterName.setTextColor(text_colors[0]);
			monthName.setTextColor(text_colors[0]);
			cocktailNameLayout.setBackgroundColor(bg_colors[0]);
			break;
		case 1:
			letterName.setTextColor(text_colors[1]);
			monthName.setTextColor(text_colors[1]);
			cocktailNameLayout.setBackgroundColor(bg_colors[1]);
			break;
		case 2:
			letterName.setTextColor(text_colors[2]);
			monthName.setTextColor(text_colors[2]);
			cocktailNameLayout.setBackgroundColor(bg_colors[2]);
			break;
		case 3:
			letterName.setTextColor(text_colors[3]);
			monthName.setTextColor(text_colors[3]);
			cocktailNameLayout.setBackgroundColor(bg_colors[3]);
			break;
		case 4:
			letterName.setTextColor(text_colors[4]);
			monthName.setTextColor(text_colors[4]);
			cocktailNameLayout.setBackgroundColor(bg_colors[4]);
			break;
		case 5:
			letterName.setTextColor(text_colors[5]);
			monthName.setTextColor(text_colors[5]);
			cocktailNameLayout.setBackgroundColor(bg_colors[5]);
			break;
		case 6:
			letterName.setTextColor(text_colors[6]);
			monthName.setTextColor(text_colors[6]);
			cocktailNameLayout.setBackgroundColor(bg_colors[6]);
			break;
		case 7:
			letterName.setTextColor(text_colors[7]);
			monthName.setTextColor(text_colors[7]);
			cocktailNameLayout.setBackgroundColor(bg_colors[7]);
			break;
		case 8:
			letterName.setTextColor(text_colors[8]);
			monthName.setTextColor(text_colors[8]);
			cocktailNameLayout.setBackgroundColor(bg_colors[8]);
			break;
		case 9:
			letterName.setTextColor(text_colors[9]);
			monthName.setTextColor(text_colors[9]);
			cocktailNameLayout.setBackgroundColor(bg_colors[9]);
			break;
		case 10:
			letterName.setTextColor(text_colors[10]);
			monthName.setTextColor(text_colors[10]);
			cocktailNameLayout.setBackgroundColor(bg_colors[10]);
			break;
		case 11:
			letterName.setTextColor(text_colors[11]);
			monthName.setTextColor(text_colors[11]);
			cocktailNameLayout.setBackgroundColor(bg_colors[11]);
			break;
		default:
			letterName.setTextColor(text_colors[0]);
			monthName.setTextColor(text_colors[0]);
			cocktailNameLayout.setBackgroundColor(bg_colors[0]);
			break;
		}
	}
	

	//change image based on month value
	public void DisplayCocktailImage(int monthValue, ImageView cockTailImage) {
		switch (monthValue) {
		case 0:
			cockTailImage.setImageResource(R.drawable.image_1);
			break;
		case 1:
			cockTailImage.setImageResource(R.drawable.image_2);
			break;
		case 2:
			cockTailImage.setImageResource(R.drawable.image_3);
			break;
		case 3:
			cockTailImage.setImageResource(R.drawable.image_4);
			break;
		case 4:
			cockTailImage.setImageResource(R.drawable.image_5);
			break;
		case 5:
			cockTailImage.setImageResource(R.drawable.image_6);
			break;
		case 6:
			cockTailImage.setImageResource(R.drawable.image_7);
			break;
		case 7:
			cockTailImage.setImageResource(R.drawable.image_8);
			break;
		case 8:
			cockTailImage.setImageResource(R.drawable.image_9);
			break;
		case 9:
			cockTailImage.setImageResource(R.drawable.image_10);
			break;
		case 10:
			cockTailImage.setImageResource(R.drawable.image_11);
			break;
		case 11:
			cockTailImage.setImageResource(R.drawable.image_12);
			break;
		default:
			cockTailImage.setImageResource(R.drawable.image_1);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}

