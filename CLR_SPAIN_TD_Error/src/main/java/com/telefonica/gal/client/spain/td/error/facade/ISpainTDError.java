package com.telefonica.gal.client.spain.td.error.facade;

import com.telefonica.gal.client.spain.td.error.msg.ErrorKey;
import com.telefonica.gal.client.spain.td.error.msg.ErrorResponse;

public interface ISpainTDError {
    ErrorResponse search(ErrorKey tdkey);
}
