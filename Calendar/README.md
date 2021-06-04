使用方法：
---
* MonthCalendarView的使用<br/>
```
<com.jeek.calendar.widget.calendar.month.MonthCalendarView
    android:id="@+id/mcvCalendar"
    android:layout_width="match_parent"
    android:layout_height="@dimen/small_month_calendar_height"
    app:month_day_text_size="@integer/small_calendar_text_size"
    app:month_selected_circle_color="@color/color_select_date_dialog_edit_text_bg_focus"
    app:month_selected_circle_today_color="@color/color_select_date_dialog_edit_text_bg_focus"
    app:month_show_lunar="true"
    app:month_show_task_hint="false"
    app:month_show_holiday_hint="true"
    app:month_text_size="@integer/small_calendar_text_size"/>
```

* ScheduleLayout的使用<br/>

layout_schedule.xml文件，必须包含MonthCalendarView、WeekCalendarView和ScheduleRecyclerView，可以直接引用改文件作为布局。<br/>

```
ScheduleLayout：
app:default_view="week" <!-默认周视图->
app:default_view="month" <!-默认月视图->
app:auto_change_month_row="false" <!-不自动改变五六行->
app:auto_change_month_row="true" <!-自动改变五六行->
```

* 设置日期监听<br/>
```
slSchedule.setOnCalendarClickListener(new OnCalendarClickListener() {
    @Override
    public void onClickDate(int year, int month, int day) {
        //监听获得点击的年月日
    }
});
```
* 跳转到今天<br/>
```
slSchedule.getMonthCalendar().setTodayToView();
```
* 跳转到某一天<br/>
```
slSchedule.initData(year, month, day);
```
