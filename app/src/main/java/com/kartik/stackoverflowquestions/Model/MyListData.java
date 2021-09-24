package com.kartik.stackoverflowquestions.Model;

public class MyListData {

    public int getUp_vote_count() {
        return this.up_vote_count; }
    public void setUp_vote_count(int up_vote_count) {
        this.up_vote_count = up_vote_count; }
    int up_vote_count;

    public int getQuestion_id() {
        return this.question_id; }
    public void setQuestion_id(int question_id) {
        this.question_id = question_id; }
    int question_id;

    public String getTitle() {
        return this.title; }
    public void setTitle(String title) {
        this.title = title; }
    String title;
}
