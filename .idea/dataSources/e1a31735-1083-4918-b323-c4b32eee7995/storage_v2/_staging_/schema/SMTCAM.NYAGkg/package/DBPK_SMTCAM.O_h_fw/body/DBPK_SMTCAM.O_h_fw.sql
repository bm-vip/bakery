create package body dbpk_smtcam is
  ------------------test
  procedure test (mm out sys_refcursor)is
    begin
      open mm for
      select 'fokaname' fokaname from dual;
      end test;
end dbpk_smtcam;


