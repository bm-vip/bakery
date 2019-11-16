create package body dbpk_smtcam is
  ------------------test
  procedure test (param in varchar2(400),mm out varchar2(400))is
    begin
      mm:=param;
      --       open mm for
      --       select 'fokaname' fokaname from dual;
    end test;
end dbpk_smtcam;
/

