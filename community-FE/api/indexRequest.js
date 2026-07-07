import { getServerUrl } from '../utils/function.js';
import { requestJson } from '../utils/request.js';


export const getPosts = (page = 0) => {
    const result = requestJson(
        `${getServerUrl()}/posts?page=${page}`,
        {
            credentials: 'include',
        },
    );
    return result;
};


export const searchPosts = (keyword, page = 0, sort = 'recent') => {
    const query = new URLSearchParams({
        keyword,
        page, 
        sort,
    });
    const result = requestJson(
        `${getServerUrl()}/posts/search?${query.toString()}`,
        {
            credentials: 'include',
        },
    );
    return result;
};