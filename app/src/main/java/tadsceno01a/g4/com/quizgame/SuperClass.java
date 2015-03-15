package tadsceno01a.g4.com.quizgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;

public class SuperClass extends ActionBarActivity
{
    //region | Methods

    public void openSearch()
    {

    }

    public void openSettings()
    {

    }

    public void Alert(String Titulo, String Mensagem)
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

        alertDialog.setIcon(R.drawable.androidhappy);
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
                Alert("Informação", "Operação cancelada");
            }
        });

        alertDialog.setIcon(R.drawable.androidhappy);
        alertDialog.show();
    }

    //endregion
}
