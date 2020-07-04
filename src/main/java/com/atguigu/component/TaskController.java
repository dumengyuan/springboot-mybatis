package com.atguigu.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskController {

    /**
     *  @Scheduled:定时规则
     *       cron：项目启动后每5秒执行一次
     *
     *       fixedDelay：距离上一次定时任务执行完毕后N毫秒再执行，
     *       执行A任务花了5秒，比如参数是3000，A任务执行完成之后，再过3秒执行
     *
     *       fixedRate：执行周期，执行频率
     *       定时任务执行开始，再过N毫秒后执行，
     *       执行A任务花了2秒，比如参数是3000，A任务执行完成之后，再过1秒后执行，
     *       执行A任务花了15秒，比如参数是3000，A任务执行完成之后，立即执行。
     *
     *      cron 用空格分开的7个部分，按顺序依次为
     * 		①秒：0~59
     * 		②分钟：0~59
     * 		③小时：0~23
     * 		④日期：1~31，但是需要考虑月的实际天数 day-of-month
     * 		⑤月：1~12
     * 		⑥星期：1~7（1为星期日）或SUN，MON，TUE，WED，THU，FRI，SAT day-of-week
     * 		⑦年份：1970~2099可选
     */


    @Scheduled(cron = "0/3 * * * * *")  //每隔3秒打印一次
    //@Scheduled(fixedRate = 3000)
    //@Scheduled(fixedDelay = 3000)
    public void myTask() throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));

        Thread.sleep(5000);
    }

}
