function ToLocalizingDateString(date, showTime) {    
    if (culture === "fa-IR") {
        return  gregorianStringToShamsiString(date, showTime);
    } else {
        return toGregorianString(date, showTime);
    }   
}
function toGregorianString(shamsiString, showTime) {
    if (isNullOrEmpty(shamsiString)) {
        if (!isNullOrEmpty(showTime) && showTime) {
            return "0001-01-01 00:00:00";
        }
        return "0001-01-01";
    }
    if (culture === "fa-IR") {
        return shamsiStringTogregorianString(shamsiString, showTime);
    } else {
        var date = dateSpliter(shamsiString);
        var year = "{0}/{1}/{2}".format(date.year, date.month, date.day);
        if (!isNullOrEmpty(showTime) && showTime) {
            return "{0} {1}:{2}:{3}".format(
                year,
                date.hour,
                date.minute,
                date.second);
        }
        return year;
    }    
}

function cSharpDateToLocalizingString(cSharpDate) {
    var date = eval("new " + cSharpDate.replace(/\//g, ""));
    if (culture === "fa-IR") {
        var json = toJalaali(date.getFullYear(), date.getMonth(), date.getDate());
        return "{0}/{1}/{2} {3}:{4}:{5}".format(json.jy, json.jm, json.jd, date.getHours(), date.getMinutes(), date.getSeconds());
    } else {
        return "{0}/{1}/{2} {3}:{4}:{5}".format(date.getFullYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());        
    }
}

function shamsiStringTogregorianString(shamsiString, showTime) {
    shamsiString = persianDigitToEnglish(shamsiString);
    var date = dateSpliter(shamsiString);
    var json = toGregorian(date.year, date.month, date.day);
    var year = "{0}/{1}/{2}".format(json.gy, json.gm, json.gd);
    if (!isNullOrEmpty(showTime) && showTime) {
        return "{0} {1}:{2}:{3}".format(
            year,
            date.hour,
            date.minute,
            date.second);
    }
    return year;
}

function gregorianStringToShamsiString(gregorianString, showTime) {
    var date = dateSpliter(gregorianString);
    var json = toJalaali(date.year, date.month, date.day);
    var year = "{0}/{1}/{2}".format(json.jy, json.jm, json.jd);
    if (!isNullOrEmpty(showTime) && showTime) {
        return "{0} {1}:{2}:{3}".format(
            year,
            date.hour,
            date.minute,
            date.second);
    }
    return year;
}

function dateSpliter(dateString) {
    if (dateString.indexOf('-') > -1) {
        dateString = dateString.split('T');
    } else if (dateString.indexOf('  ') > -1) {
        dateString = dateString.split('  ');
    }
    var spliter = '/';
    if (isArray(dateString)) {
        var year = dateString[0];
        var time = dateString[1];
        if (year.indexOf('-') > -1)
            spliter = '-';
        return {
            year: parseInt(year.split(spliter)[0]),
            month: parseInt(year.split(spliter)[1]),
            day: parseInt(year.split(spliter)[2]),
            hour: parseInt(time.split(':')[0]),
            minute: parseInt(time.split(':')[1]),
            second: parseInt(time.split(':')[2])
        }
    }
    if (dateString.indexOf('-') > -1)
        spliter = '-';
    return { year: parseInt(dateString.split(spliter)[0]), month: parseInt(dateString.split(spliter)[1]), day: parseInt(dateString.split(spliter)[2]), hour: 0, minute: 0, second: 0 }
}