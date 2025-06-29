SET SERVEROUTPUT ON;

DECLARE
   v_num NUMBER := 5;
   v_sum NUMBER := 0;
BEGIN
   IF v_num > 0 THEN
      DBMS_OUTPUT.PUT_LINE('Positive Number');
   ELSE
      DBMS_OUTPUT.PUT_LINE('Zero or Negative Number');
   END IF;

   WHILE v_num > 0 LOOP
      DBMS_OUTPUT.PUT_LINE('Counting down: ' || v_num);
      v_num := v_num - 1;
   END LOOP;

   FOR i IN 1..5 LOOP
      v_sum := v_sum + i;
   END LOOP;

   DBMS_OUTPUT.PUT_LINE('Sum from 1 to 5: ' || v_sum);
END;
/