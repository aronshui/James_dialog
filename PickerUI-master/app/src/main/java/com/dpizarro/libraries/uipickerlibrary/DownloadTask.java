package com.dpizarro.libraries.uipickerlibrary;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-06-07.
 */
public class DownloadTask extends AsyncTask<Void,Integer,Boolean> {


    private Context context;

    //后台任务开始执行之间调用，用于进行一些界面上的初始化操作
    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    //耗时操作在此方法中实现，不可更新UI
    //任务一旦完成就可以通过return语句来将任务的执行结果进行返回，如果AsyncTask的第三个泛型参数指定的是Void，就可以不返回任务执行结果。
    // 注意，在这个方法中是不可以进行UI操作的，
    //果需要更新UI元素，比如说反馈当前任务的执行进度，可以调用publishProgress(Progress...)方法来完成。
    @Override
    protected Boolean doInBackground(Void... params) {
        return null;
    }
    //后台任务中调用了publishProgress(Progress...)方法后，这个方法就很快会被调用，
    // 方法中携带的参数就是在后台任务中传递过来的。在这个方法中可以对UI进行操作，利用参数中的数值就可以对界面元素进行相应的更新。
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }


    //在返回结果return之后被调用，可以进行操作UI，主要进行结果之后的操作，例如关掉请求对话框
    // 返回的数据会作为参数传递到此方法中，可以利用返回的数据来进行一些UI操作，比如说提醒任务执行的结果，以及关闭掉进度条对话框等。
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        if (aBoolean){
            Toast.makeText(context,"下载成功",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"下载失败",Toast.LENGTH_LONG).show();
        }
    }
}
