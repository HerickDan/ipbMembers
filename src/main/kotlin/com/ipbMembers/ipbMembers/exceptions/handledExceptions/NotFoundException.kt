package com.ipbMembers.ipbMembers.exceptions.handledExceptions

import com.ipbMembers.ipbMembers.commons.enum.ErrorMessage

class NotFoundException( val errorMessage: ErrorMessage): RuntimeException()