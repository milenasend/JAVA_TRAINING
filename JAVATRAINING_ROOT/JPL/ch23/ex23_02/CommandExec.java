/*
 * 練習問題23.2 p.592
 * コマンドラインの引数に対してexecを実行して、コマンドから出力を表示するプログラムを作成しなさい。
 * 各出力行の前には行番号を表示しなさい
 */

package ch23.ex23_02;

import java.io.BufferedReader;
// import java.io.InputStreamReader;
import java.io.StringReader;

public class CommandExec
{
    static BufferedReader br;
    static String string;
    public static void main(String[] args)
    {
        try
        {
            // while(true)
            {
                // br = new BufferedReader(new InputStreamReader(System.in));
                br = new BufferedReader(new StringReader(args[0]));
                string = br.readLine();
                System.out.println(string);
                Process proc = Runtime.getRuntime().exec(string);
                Plug.plugTogether(System.out, proc.getInputStream());
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            Plug.threadRun = false;
            return;
        }
    }
}
