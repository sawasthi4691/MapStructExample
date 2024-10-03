



WITH RankedUsers AS (
    SELECT 
        asset.t_user.id_user,
        asset.t_user.email,
        asset.t_user.first_name,
        asset.t_user.last_name,
        asset.t_user.enabled,
        asset.t_user.notifications_enabled,
        asset.t_user.id_perimeter,
        asset.t_user.cgu_signed,
        asset.t_user_role.id_user_role,
        asset.t_user_role.id_role,
        asset.t_role.id_role,
        asset.t_role.role_name,
        asset.t_role.id_default_perimeter,
        asset.t_user_investor_right.id_user_investor_manager,
        asset.t_user_investor_right.id_user,
        asset.t_user_investor_right.id_investor_manager,
        asset.t_user_investor_right.id_right,
        asset.t_user_investor_right.from_role,
        asset.t_right.id_right,
        asset.t_right.name,
        asset.t_investor_manager.id,
        asset.t_investor_manager.counterparty_id,
        asset.t_investor_manager.electronic_signature,
        asset.t_investor_manager.connexion_canal,
        asset.t_counterparty.id,
        asset.t_counterparty.name,
        asset.t_counterparty.sector_code,
        asset.t_counterparty.rating_code,
        asset.t_counterparty.country_code,
        asset.t_counterparty.description,
        ROW_NUMBER() OVER (PARTITION BY asset.t_user.id_user ORDER BY asset.t_user.first_name ASC) AS RowNum
    FROM asset.t_user
    LEFT OUTER JOIN asset.t_user_role
        ON asset.t_user.id_user = asset.t_user_role.id_user
    LEFT OUTER JOIN asset.t_role
        ON asset.t_user_role.id_role = asset.t_role.id_role
    LEFT OUTER JOIN asset.t_user_investor_right
        ON asset.t_user.id_user = asset.t_user_investor_right.id_user
    LEFT OUTER JOIN asset.t_right
        ON asset.t_right.id_right = asset.t_user_investor_right.id_right
    LEFT OUTER JOIN asset.t_investor_manager
        ON asset.t_investor_manager.id = asset.t_user_investor_right.id_investor_manager
    LEFT OUTER JOIN asset.t_counterparty
        ON asset.t_investor_manager.counterparty_id = asset.t_counterparty.id
    WHERE asset.t_user_investor_right.id_investor_manager = 2
)
SELECT * FROM RankedUsers
WHERE RowNum = 1
ORDER BY id_user ASC;