package com.telefonica.gal.client.spain.td.error.facade;

import com.telefonica.gal.client.spain.td.error.msg.ErrorInfo;
import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;

public interface ISpainTDError {
    ErrorInfo search(ErrorKey tdkey);
}
