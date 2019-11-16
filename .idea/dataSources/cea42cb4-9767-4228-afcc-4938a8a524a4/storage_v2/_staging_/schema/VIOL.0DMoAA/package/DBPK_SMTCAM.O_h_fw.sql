create package dbpk_smtcam is
  ------------------test
  procedure test (param in varchar2(200),mm out varchar2(200));
end dbpk_smtcam;
/

create package body dbpk_smtcam is
  ------------------test
  procedure test (param in varchar2(200),mm out varchar2(200))is
    begin
      mm:=param;
--       open mm for
--       select 'fokaname' fokaname from dual;
    end test;
end dbpk_smtcam;
/

