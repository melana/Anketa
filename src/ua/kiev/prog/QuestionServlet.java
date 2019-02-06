package ua.kiev.prog;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class QuestionServlet extends javax.servlet.http.HttpServlet {

    static final int QUESTION_1_YES = 0;
    static final int QUESTION_1_NO = 1;
    static final int QUESTION_2_YES = 2;
    static final int QUESTION_2_NO = 3;

    static final String TEMPLATE = "<html>" +
            "<head><title>Hometask</title></head>" +
            "<body></body></html>";

    final AtomicInteger[] result = new AtomicInteger[4];


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        final String q1 = request.getParameter("question1");
        final String q2 = request.getParameter("question2");

        final int x1 = "yes".equals(q1) ? QUESTION_1_YES : QUESTION_1_NO;
        final int x2 = "yes".equals(q2) ? QUESTION_2_YES : QUESTION_2_NO;

        result[x1].incrementAndGet();
        result[x2].incrementAndGet();

        String res = "<p>Question 1 : yes = " + result[QUESTION_1_YES] + ", no = " + result[QUESTION_1_NO] + "</p>";
        res += "<p>Question 2 : yes = " + result[QUESTION_2_YES] + ", no = " + result[QUESTION_2_NO] + "</p>";

        response.getWriter().println(String.format(TEMPLATE,res));

    }


}
