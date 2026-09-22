import xml.etree.ElementTree as ET
tree = ET.parse('apktool_smali/res/values/public.xml')
root = tree.getroot()
names = [
    'conversation_auth_required_error',
    'conversation_settings_auth_required_error',
    'document_scanner_auth_required_error',
    'notification_auth_error',
    'onboarding_auth_error',
    'sign_practice_auth_error',
    'sign_video_upload_auth_error',
    'speech_auth_failed_error',
    'setup_auth_failed_error',
    'setup_generic_error',
    'setup_missing_info_error',
    'setup_session_expired_error'
]
for child in root.findall('public'):
    if child.attrib.get('type') == 'string' and child.attrib.get('name') in names:
        print(child.attrib.get('name') + ': ' + str(child.attrib.get('id')))
