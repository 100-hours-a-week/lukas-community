export const parseJsonSafe = async response => {
    const contentType = response.headers.get('content-type') || '';

    if (!contentType.includes('application/json')) {
        return null;
    }

    try {
        return await response.json();
    } catch (error) {
        return null;
    }
};

export const requestJson = async (url, options = {}) => {

    const accessToken = localStorage.getItem('accessToken');

    const headers = {
        ...(options.headers || {}),
    };

    if (accessToken) {
        headers.Authorization = `Bearer ${accessToken}`;
    }

    const response = await fetch(url, {
        ...options,
        headers,
        credentials: 'include',
    });

    const body = await parseJsonSafe(response);

    return {
        response,
        ok: response.ok,
        status: response.status,
        code: body && body.code ? body.code : null,
        data: body && Object.prototype.hasOwnProperty.call(body, 'data')
            ? body.data
            : null,
        body,
    };
};