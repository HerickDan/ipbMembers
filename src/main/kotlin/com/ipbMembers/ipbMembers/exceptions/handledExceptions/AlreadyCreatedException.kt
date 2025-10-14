package com.ipbMembers.ipbMembers.exceptions.handledExceptions

import com.ipbMembers.ipbMembers.commons.enum.ErrorMessage

class AlreadyCreatedException(val errorMessage: ErrorMessage): RuntimeException()