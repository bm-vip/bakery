(function ($) {

    var o = $({});

    $.subscribe = function () {
        o.on.apply(o, arguments);
    };

    $.unsubscribe = function () {
        o.off.apply(o, arguments);
    };

    $.publish = function () {
        o.trigger.apply(o, arguments);
    };

}(jQuery));

var culture = isNullOrEmpty($.cookie("CultureInfo")) ? "en" : $.cookie("CultureInfo");
$.cookie.json = true;

$(function () {
    $('.date input').keydown(function (event) {
        event.preventDefault();
    });
});

if (!String.prototype.format) {
    String.prototype.format = function () {
        var args = arguments;
        return this.replace(/{(\d+)}/g, function (match, number) {
            return typeof args[number] != 'undefined'
                ? args[number]
                : match
                ;
        });
    };
}


function loadPages(page) {
    if (window.location.href.indexOf("pages/") > 0) {
        window.location.href = page;
    } else {
        window.location.href = "pages/" + page;
    }
}

function loadScriptRunTime(url, callback) {
    // Adding the script tag to the head as suggested before
    var head = document.getElementsByTagName('head')[0];
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = url;

    // Then bind the event to the callback function.
    // There are several events for cross browser compatibility.
    script.onreadystatechange = callback;
    script.onload = callback;

    // Fire the loading
    head.appendChild(script);
}

function checkUserLogin(callback) {
    if (!isNullOrEmpty($.cookie("userLogin"))) {
        if (typeof callback === 'function') {
            callback();
        }
    } else {
        $.blockUI(blockUiOptions());
        $.getJSON("../com.bakery.controller/Common.aspx", {cmd: "session_state"}, function (entity) {
            $.unblockUI();
            if (entity.error == null) {
                if (typeof callback === 'function') {
                    callback();
                }
            } else {
                $.subscribe("afterLogin", callback);
                $('#loginModal').modal('show');
            }
        });
    }
}



function changeUrlParameterAndReload(param, value) {
    changeUrlParameter(param, value);
    location.reload();
}

function changeUrlParameter(param, value) {
    var currentURL = window.location.href + '&';
    var change = new RegExp('(' + param + ')=(.*)&', 'g');
    var newURL = currentURL.replace(change, '$1=' + value + '&');

    if (getURLParameter(param) !== "") {
        try {
            window.history.replaceState('', '', newURL.slice(0, -1));
        } catch (e) {
            console.log(e);
        }
    } else {
        var currURL = window.location.href;
        if (currURL.indexOf("?") !== -1) {
            window.history.replaceState('', '', currentURL.slice(0, -1) + '&' + param + '=' + value);
        } else {
            window.history.replaceState('', '', currentURL.slice(0, -1) + '?' + param + '=' + value);
        }
    }
}

function getURLParameter(name) {
    var regexS = "[\\?&]" + name + "=([^&#]*)",
        regex = new RegExp(regexS),
        results = regex.exec(window.location.search);
    if (results == null) {
        return "";
    } else {
        return decodeURIComponent(results[1].replace(/\+/g, " "));
    }
}

function removeUrlparameter(parameter) {
    var url = document.location.href;
    var urlparts = url.split('?');

    if (urlparts.length >= 2) {
        var urlBase = urlparts.shift();
        var queryString = urlparts.join("?");

        var prefix = encodeURIComponent(parameter) + '=';
        var pars = queryString.split(/[&;]/g);
        for (var i = pars.length; i-- > 0;)
            if (pars[i].lastIndexOf(prefix, 0) !== -1)
                pars.splice(i, 1);
        url = urlBase + pars.join('&');
        window.history.pushState('', document.title, url); // added this line to push the new url directly to url bar .

    }
    return url;
}

function show_info(mes, fixStatus) {
    $("#myAlert .alert-content").html(mes);
    if (isNullOrEmpty(fixStatus) && fixStatus) {
        $("#myAlert").removeClass("alert-danger alert-warning alert-success").addClass("alert-info").show();
    } else {
        $("#myAlert").removeClass("alert-danger alert-warning alert-success").addClass("alert-info").show().delay(3000).fadeOut();
    }

}

function show_success(mes) {
    $("#myAlert .alert-content").html(mes);
    $("#myAlert").removeClass("alert-danger alert-warning alert-info").addClass("alert-success").show().delay(3000).fadeOut();

}

function show_warning(mes, fixStatus) {
    $("#myAlert .alert-content").html(mes);
    if (isNullOrEmpty(fixStatus) && fixStatus) {
        $("#myAlert").removeClass("alert-success alert-danger alert-info").addClass("alert-warning").show();
    } else {
        $("#myAlert").removeClass("alert-success alert-danger alert-info").addClass("alert-warning").show().delay(3000)
            .fadeOut();
    }
}

function show_error(mes) {
    $("#myAlert .alert-content").html(mes);
    $("#myAlert").removeClass("alert-success alert-warning alert-info").addClass("alert-danger").show();

}

function convert_dotNetDateTimeToJavascript(date) {
    //var dotNetDate = new Date(parseInt(date.replace("/Date(", "").replace(")/",""), 10));
    var dotNetDate = eval("new " + date.replace(/\//g, ""));
    return dotNetDate.getFullYear() + "/" + (dotNetDate.getMonth() + 1) + "/" + (dotNetDate.getDate()) + " " + dotNetDate.getHours() + ":" + dotNetDate.getMinutes() + ":" + dotNetDate.getSeconds();
}
function get(expr,defaultValue) {
    try {
        return expr();
    }catch (e) {
       return isNullOrEmpty(defaultValue) ? '' : defaultValue;
    }
}
function arrayToJsonArray(arr) {
    try{
        return arr.reduce((json, value, key) => { json[key] = {id:value}; return json; },[]);
    } catch (e) {
        return [];
    }
}

function isNullOrEmpty(param) {
    if (param == null)
        return true;
    if (param == "null")
        return true;
    if (param == undefined)
        return true;
    if (param == "undefined")
        return true;
    if ((param + "").trim() == "")
        return true;
    return false;
}

function addPeriod(nStr) {
    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}

function separetorPrice(id) {
    $(id).each(function () {
        val = $.trim($(this).html());
        if ($.isNumeric(val)) {
            res = addPeriod(val);
            $(this).html(res);
        }
    });
}


function getTagsLabel(element) {
    var labels = [];
    $.each(element.tagsinput('items'), function (i, item) {
        labels.push(item.label);
    });
    return labels;
}

function getTagsFile(element) {
    var files = [];
    $.each(element.tagsinput('items'), function (i, item) {
        if (item.id !== item.label)
            files.push(item.id);
    });
    return files;
}

function getEmptyTagsLabel(element) {
    var labels = [];
    $.each(element.tagsinput('items'), function (i, item) {
        if (item.id === item.label)
            labels.push(item.label);
    });
    return labels;
}

function persianDigitToEnglish(value) {
    return value.replace(/۰/g, "0").replace(/۱/g, "1").replace(/۲/g, "2").replace(/۳/g, "3").replace(/۴/g, "4").replace(/۵/g, "5").replace(/۶/g, "6").replace(/۷/g, "7").replace(/۸/g, "8").replace(/۹/g, "9");
}

function blockUiOptions() {
    return {
        message: '<i class="fa fa-refresh fa-spin fa-2x"></i><br/>' + resources.processing,
        fadeIn: 1000,
        //timeout: 1000,
        overlayCSS: {
            backgroundColor: '#FFF',
            opacity: 0.8,
            cursor: 'wait'
        },
        css: {
            border: 0,
            padding: 0,
            color: '#333',
            backgroundColor: 'transparent'
        },
        onBlock: function () {
            //alert('Page is now blocked, FadeIn complete.');
        }
    }
}

function datePickerOptions() {
    return {
        Placement: 'bottom',
        EnglishNumber: true,
        Trigger: 'click',
        EnableTimePicker: false,
        DisableBeforeToday: false,
        TargetSelector: '.date input',
        GroupId: '',
        ToDate: false,
        FromDate: false,
        Disabled: false,
        Format: 'yyyy/MM/dd',
        GregorianStartDayIndex: 0,
        IsGregorian: false
    }
}
function validationOptions(rules,messages,callback) {
    return {
        ignore: '.skip',
        rules: rules,
        messages: messages,
        highlight: function(element, errorClass, validClass) {
            $(element).closest("div[class^='col-md-']").addClass("has-error").removeClass("has-success");
        },
        unhighlight: function(element, errorClass, validClass) {
            $(element).closest("div[class^='col-md-']").addClass("has-success").removeClass("has-error");
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if (element.is(":radio") || element.is(":checkbox")) {
                error.appendTo(element.parent().parent());
            } else if (element.parent('.input-group').length) {
                error.insertAfter(element.closest('.input-group'));
            } else {
                error.insertAfter(element);
            }
        },
        submitHandler: function(form) {
            if (typeof callback === 'function') {
                callback();
            }
        }
    }
}
function tableOptions() {
    return {
        "responsive": true,
        "processing": true,
        "searching": false,
        "sort": true,
        "createdRow": function (row, data, index) {
            var fn = window["createdRow"];
            if (typeof fn === 'function') {
                fn(row, data, index);
            }
        }
    }
}

function initAjaxTable(selector, columns, url, filterFunction) {
    var opts = tableOptions();
    opts.serverSide = true;
    opts.columns = columns;
    opts.ajax = {
        'type': 'GET',
        'url': url,
        'data': function (data) {
            var fn = window[filterFunction];
            if (typeof fn === 'function') {
                data.entity = JSON.stringify(fn());
            }
        },
        'datatype': 'json',
        'error': function (xhr) {
            show_error(xhr.responseText);
        }
    };
    return $(selector).DataTable(opts);
}

function initTable(selector, columns, data) {
    var opts = tableOptions();
    opts.columns = columns;
    opts.data = data;
    return $(selector).DataTable(opts);
}

function showModal(title, callback) {
    $('#myModal .modal-title').html(title);
    if (typeof callback === 'function') {
        $('#myModal').on('shown.bs.modal', function () {
            callback();
            $(this).off('shown.bs.modal');
        }).modal('show');
    } else {
        $('#myModal').modal('show');
    }
}

function goToByScroll(selector) {
    $('html, body').animate({
        scrollTop: $(selector).offset().top
    }, 2000);
}

function isArray(value) {
    return value && typeof value === 'object' && value.constructor === Array;
}

function showUserAccount() {
    $('#userAccount span').text(resources.hello.format($.cookie("userLogin").name));
    loadUserControlToElement("UserAccount", null, "#myModal .modal-body", function () {
        showModal(resources.userDetail, initModal);
    });
}