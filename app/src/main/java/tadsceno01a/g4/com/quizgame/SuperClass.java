package tadsceno01a.g4.com.quizgame;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperClass extends ActionBarActivity
{
    //region | Methods

    public void openSearch()
    {

    }

    public void openSettings()
    {

    }

    public void Alert(String Titulo, String Mensagem, AlertType TipoAlerta)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(Titulo);
        alertDialog.setMessage(Mensagem);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });

        if(TipoAlerta == AlertType.Info)
        {
            alertDialog.setIcon(R.drawable.androidhappy);
        }

        if(TipoAlerta == AlertType.Error)
        {
            alertDialog.setIcon(R.drawable.ic_action_error);
        }

        if(TipoAlerta == AlertType.Warning)
        {
            alertDialog.setIcon(R.drawable.ic_action_warning);
        }

        alertDialog.show();
    }

    public void Quit()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Confirmação");
        alertDialog.setMessage("Você deseja realmente sair do aplicativo");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Sim", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Não", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                Alert("Informação", "Operação cancelada", AlertType.Info);
            }
        });

        alertDialog.setIcon(R.drawable.androidhappy);
        alertDialog.show();
    }

    public boolean IsEmpty(EditText input)
    {
        String ed_text = input.getText().toString().trim();

        if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean IsEqual(EditText textbox, String input)
    {
        return textbox.getText().toString().equalsIgnoreCase(input);
    }

    public void WriteFile(String filename, String content)
    {
        FileOutputStream outputStream;

        try
        {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String ReadFile(String filename)
    {
        try
        {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(openFileInput(filename)));
            String inputString;
            StringBuffer stringBuffer = new StringBuffer();

            while ((inputString = inputReader.readLine()) != null)
            {
                stringBuffer.append(inputString + "\n");
            }

            return stringBuffer.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public void DeleteFile(String name)
    {
        deleteFile(name);
    }

    //endregion

    public enum AlertType
    {
        Info, Warning, Error
    }
}
