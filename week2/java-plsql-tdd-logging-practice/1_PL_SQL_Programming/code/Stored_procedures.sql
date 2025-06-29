SET SERVEROUTPUT ON;

DECLARE
   PROCEDURE check_even_odd (num IN NUMBER) IS
   BEGIN
      IF MOD(num, 2) = 0 THEN
         DBMS_OUTPUT.PUT_LINE(num || ' is Even');
      ELSE
         DBMS_OUTPUT.PUT_LINE(num || ' is Odd');
      END IF;
   END;
BEGIN
   check_even_odd(10);
   check_even_odd(7);
END;
/